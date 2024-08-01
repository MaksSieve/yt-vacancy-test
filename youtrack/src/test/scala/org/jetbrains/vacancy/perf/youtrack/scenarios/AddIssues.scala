package org.jetbrains.vacancy.perf.youtrack.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.cases._

import scala.util.Random

object AddIssues {
  def apply(authToken: String, projectId: String): ScenarioBuilder =
    new AddIssues(authToken, projectId).scn
}

class AddIssues(authToken: String, projectId: String) {

  val userFeeder = csv("feeders/users.csv").random

  val issueSummaryFeeder: Iterator[Map[String, String]] = Iterator.continually {
    // make a random number of random words
    val words = List.fill(Random.between(3,7))(Random.alphanumeric.take(Random.between(1, 15)).mkString)
    Map("issueSummary" -> words.mkString(" "))
  }

  val issueDescFeeder: Iterator[Map[String, String]] = Iterator.continually {
    val words = List.fill(Random.between(20,31))(Random.alphanumeric.take(Random.between(1, 16)).mkString)
    Map("issueDesc" -> words.mkString(" "))
  }

  val projectIdFeeder = Iterator.continually {
    Map("projectId" -> projectId)
  }

  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .feed(projectIdFeeder)
    .feed(userFeeder)
    .feed(issueSummaryFeeder)
    .feed(issueDescFeeder)
    .exec(Issues.addIssue)
}
