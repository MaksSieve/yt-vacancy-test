package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Stability extends Simulation with Annotations {

  setUp(
    AddIssues(getStringParam("apiAdminKey"), getStringParam("projectUUID")).inject(
      // разгон
      rampUsersPerSec(0) to intensity.toInt during rampDuration,
      // полка
      constantUsersPerSec(intensity.toInt) during stageDuration,
    ),
  ).protocols(
    httpProtocol,
    // длительность теста = разгон + полка
  ).maxDuration(testDuration)

}
