package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class MaxPerformance extends Simulation with Annotations {

  val startingUsers: Int = getIntParam("startingUsers")

  setUp(
    UserActivity().inject(
      incrementConcurrentUsers(intensity.toInt)
        .times(stagesNumber)
        .eachLevelLasting(stageDuration)
        .separatedByRampsLasting(rampDuration)
        .startingFrom(startingUsers),
    )
  ).protocols(httpProtocol)
    .maxDuration(testDuration)
}
