package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios.AddIssues

import scala.concurrent.duration.DurationInt

class IssueGenerationTestStab extends Simulation with Annotations {

  val projectId: String = getStringParam("projectId")
  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random

  setUp(
    AddIssues(projectId, userFeeder)
      .inject(
        constantUsersPerSec(15).during(6700 seconds)
      )
  )
    .protocols(httpProtocol)
    .maxDuration(6700 seconds)
}
