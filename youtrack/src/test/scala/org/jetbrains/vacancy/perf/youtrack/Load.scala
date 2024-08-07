package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.galaxio.gatling.influxdb.Annotations
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Load extends Simulation with Annotations {

  setUp(
    UserActivity().inject(
      rampConcurrentUsers(0) to intensity.toInt during rampDuration,
      constantConcurrentUsers(intensity.toInt) during stageDuration,
    )
  )
    .protocols(httpProtocol)
    .maxDuration(testDuration)
    .assertions(
      details("openIssue").responseTime.percentile(90).lte(500),
      details("issuesGetter").responseTime.percentile(90).lte(1000),
      details("sortedIssues").responseTime.percentile(90).lte(500),
      global.failedRequests.percent.lte(1)
    )
}
