package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios.AddIssues

class IssueGenerationTest extends Simulation with Annotations {
  setUp(
    AddIssues(
      getStringParam("apiAdminKey"),
      getStringParam("projectUUID")
    ).inject(
      rampUsersPerSec(0).to(intensity).during(rampDuration)
    )
  ).protocols(httpProtocol)
    .maxDuration(testDuration)
}
