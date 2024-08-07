package org.jetbrains.vacancy.perf.youtrack.scenarios

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.cases._
import org.jetbrains.vacancy.perf.youtrack.scenarios.UserActivity.commandsFeeder

import scala.util.Random


object UserActivity {

  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random
  val searchQueryFeeder: BatchableFeederBuilder[String] = csv("feeders/queries.csv").random
  val issueTagFeeder: BatchableFeederBuilder[String] = csv("feeders/tags.csv").random
  val commandsFeeder: BatchableFeederBuilder[String] = csv("feeders/commands.csv").random

  def apply(): ScenarioBuilder =
    new UserActivity(userFeeder, searchQueryFeeder, issueTagFeeder).scn
}



class UserActivity(
                    userFeeder: BatchableFeederBuilder[String],
                    searchQueryFeeder: BatchableFeederBuilder[String],
                    issueTagFeeder: BatchableFeederBuilder[String]
                  ) {

  val chooseIssueId: Session => Session = (session: Session) => {
    val issues = session("issueIds").as[Vector[String]]
    session.set("selectedIssueId", issues(Random.between(0, issues.length)))
  }

  val chooseIssueIdToLink: Session => Session = (session: Session) => {
      val issues = session("issueReadableIds").as[Vector[String]]
      session.set(
        "issueIdToLink",
        issues(Random.between(0, issues.length))
      )
  }

  val scn: ScenarioBuilder = scenario("Add Issues Scenario")
    .forever("")(
      pace(3600)
        .feed(userFeeder)
        .group("search")(
          pace(60)
            .feed(searchQueryFeeder)
            .exec(Issues.searchAssist)
            .pause(1,10)
            .exec(Issues.sortedIssues)
            .pause(1,10)
            .exec(Issues.issuesGetter)
            .pause(1,10)
        )
        .repeat(3)(
          group("open")(
            pace(60)
              .exec(chooseIssueId)
              .exec(Users.me)
              .pause(1,10)
              .exec(Issues.openIssue)
              .pause(1,10)
          )
        )
        .group("change")(
          pace(60)
          .exec(chooseIssueId)
          .randomSwitch(
            25.0 -> exec(Issues.addComment),
            25.0 -> exec(Issues.changeDesc),
            25.0 -> feed(issueTagFeeder)
              .exec(Issues.addTag),
            25.0 -> exec(Users.recentIssues)
              .exec(chooseIssueIdToLink)
              .pause(1,10)
              .feed(commandsFeeder)
              .exec(Issues.addLink),
          ).pause(1, 10)
        )

    )
}
