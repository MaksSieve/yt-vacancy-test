package org.jetbrains.vacancy.perf.youtrack.scenarios

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.Utility.LoremIpsum
import org.jetbrains.vacancy.perf.youtrack.cases._

object AddIssues {
  def apply(projectId: String, userFeeder: BatchableFeederBuilder[String]): ScenarioBuilder =
    new AddIssues(projectId, userFeeder).scn
}

class AddIssues(projectId: String, userFeeder: BatchableFeederBuilder[String]) {
  val issueSummaryFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map("issueSummary" -> LoremIpsum.getRandomNumberOfWords(Range.inclusive(5, 10)))
  }

  val issueDescFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map("issueDesc" -> LoremIpsum.getRandomNumberOfWords(Range.inclusive(20, 30)))
  }

  val projectIdFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map("projectId" -> projectId)
  }

  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .feed(projectIdFeeder)
    .feed(userFeeder)
    .feed(issueSummaryFeeder)
    .feed(issueDescFeeder)
    .exec(Issues.addIssue)
}
