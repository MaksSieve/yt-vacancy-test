package org.jetbrains.vacancy.perf.youtrack.scenarios

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.cases._

import scala.util.Random


object UserActivity {
  def apply(userFeeder: BatchableFeederBuilder[String]): ScenarioBuilder =
    new UserActivity(userFeeder).scn
}



class UserActivity(userFeeder: BatchableFeederBuilder[String]) {

  val chooseIssueId: Session => Session = (session: Session) => {
    val issues = session("issueIds").as[Vector[String]]
    session.set("selectedIssueId", issues(Random.between(0, issues.length)))
  }

  val chooseIssueReadableId: Session => Session = (session: Session) => {
    val issues = session("issueReadableIds").as[Vector[String]]
    session.set("selectedIssueReadableId", issues(Random.between(0, issues.length)))
  }

  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .feed(userFeeder)
    .forever("")(
      pace(3600)
        .group("search")(
          pace(60)
            .exec(Issues.searchAssist)
            .pause(1,10)
            .exec(Issues.sortedIssues)
            .pause(1,10)
            .exec(Issues.issuesGetter)
            .pause(1,10)
        ).repeat(3)(
          group("open")(
            pace(60)
              .exec(chooseIssueId)
              .exec(Users.recentIssues)
              .pause(1,10)
              .exec(Users.me)
              .pause(1, 10)
              .exec(Issues.openIssue)
              .pause(1, 10)
          )
        ).group("change")(
          pace(60)
          .exec(chooseIssueId)
          .randomSwitch(
            33.0 -> exec(Issues.addComment),
            33.0 -> exec(Issues.changeDesc),
            34.0 -> exec(
              exec(Users.recentIssues)
                .pause(1,10)
                .exec(Issues.addLink)
            ),
          ).pause(1, 10)
        )
    )
}
