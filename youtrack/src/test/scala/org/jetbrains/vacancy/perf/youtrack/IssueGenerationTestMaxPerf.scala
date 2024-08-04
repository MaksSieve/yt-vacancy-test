package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios.AddIssues

import scala.concurrent.duration.DurationInt

class IssueGenerationTestMaxPerf extends Simulation with Annotations {

  val projectId: String = getStringParam("projectId")
  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random

  setUp(
    AddIssues(projectId, userFeeder)
      .inject(
        incrementUsersPerSec(1)
          .times(20)
          .eachLevelLasting(10 minutes)
          .separatedByRampsLasting(10 seconds)
          .startingFrom(0)
      )
  )
    .protocols(httpProtocol)
}
