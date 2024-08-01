package org.jetbrains.vacancy.perf.youtrack.scenarios

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.cases._

import scala.concurrent.duration.DurationInt
import scala.util.Random

object UserActivity {
  def apply(userFeeder: BatchableFeederBuilder[String]): ScenarioBuilder =
    new UserActivity(userFeeder).scn
}

class UserActivity(userFeeder: BatchableFeederBuilder[String]) {

  val issueSummaryFeeder: Iterator[Map[String, String]] = Iterator.continually {
    // make a random number of random words
    val words = List.fill(Random.between(3,7))(Random.alphanumeric.take(Random.between(1, 15)).mkString)
    Map("issueSummary" -> words.mkString(" "))
  }

  val issueDescFeeder: Iterator[Map[String, String]] = Iterator.continually {
    val words = List.fill(Random.between(20,31))(Random.alphanumeric.take(Random.between(1, 16)).mkString)
    Map("issueDesc" -> words.mkString(" "))
  }


  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .feed(userFeeder)
    .feed(issueSummaryFeeder)
    .feed(issueDescFeeder)
    .repeat( 10,  "search")(
      pace(60 seconds)
      .randomSwitch(
        100.0 -> exec(Issues.searchAll)
      ).exec(session => {
        println(session("issues"))
        session
      })
    )
}
