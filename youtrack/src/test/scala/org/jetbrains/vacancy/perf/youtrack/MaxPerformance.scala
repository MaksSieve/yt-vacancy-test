package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class MaxPerformance extends Simulation with Annotations {

  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random
  val startingUsers: Int = getIntParam("startingUsers")

  setUp(
    UserActivity(userFeeder).inject(
      incrementConcurrentUsers(intensity.toInt)
        .times(stagesNumber)
        .eachLevelLasting(stageDuration)
        .separatedByRampsLasting(rampDuration)
        .startingFrom(startingUsers),
    )
  ).protocols(httpProtocol)
    .maxDuration(testDuration)
}
