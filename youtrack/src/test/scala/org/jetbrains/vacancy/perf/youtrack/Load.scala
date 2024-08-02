package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Load extends Simulation with Annotations {

  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random

  setUp(
    UserActivity(userFeeder).inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration,
      constantUsersPerSec(intensity.toInt) during stageDuration,
    )
  )
    .protocols(httpProtocol)
    .maxDuration(testDuration)
}
