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

  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .feed(userFeeder)
    .repeat( 1,  "search")(
      pace(5 seconds)
      .randomSwitch(
        100.0 -> exec(Issues.searchAll)
          .exec(session => {
            val issues = session("issueIds").as[Vector[String]]
            session.set("selectedIssueId", issues(Random.between(0, issues.length)))
          })
      )
        .exec(Issues.openIssueToRead)
        .exec(Issues.changeSummary)
        .exec(Issues.addComment)
    )
}
