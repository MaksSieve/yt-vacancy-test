package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class AddUsers extends Simulation {

  // proxy is required on localhost:8888

  val apiAdminKey: String = getStringParam("apiAdminToken")
  val projectUUID: String = getStringParam("projectUUID")
  val usersToGenerate: Int = getIntParam("usersToGenerate")

  setUp(
     AddUsers(apiAdminKey, projectUUID, usersToGenerate)
     .inject(atOnceUsers(1))
  ).protocols(
    httpProtocol
  ).maxDuration(testDuration)

}
