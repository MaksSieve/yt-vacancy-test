package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._

import org.galaxio.gatling.config.SimulationConfig._
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Debug extends Simulation {

  // proxy is required on localhost:8888

  val apiAdminKey: String = getStringParam("apiAdminKey")
  val projectUUID: String = getStringParam("projectUUID")
  val projectId: String = getStringParam("projectId")

  setUp(
    // AddUsers(apiAdminKey, projectUUID)
    // .inject(atOnceUsers(1))
    AddIssues(apiAdminKey, projectId)
      .inject(atOnceUsers(1))

  ).protocols(
    httpProtocol
  ).maxDuration(testDuration)

}
