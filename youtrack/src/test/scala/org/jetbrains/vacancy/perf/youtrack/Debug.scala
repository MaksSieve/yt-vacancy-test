package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Debug extends Simulation {

  // proxy is required on localhost:8888

  val apiAdminKey: String = getStringParam("apiAdminKey")
  val projectUUID: String = getStringParam("projectUUID")
  val projectId: String = getStringParam("projectId")
  val userFeeder: BatchableFeederBuilder[String] = csv("feeders/users.csv").random

  setUp(
    // AddUsers(apiAdminKey, projectUUID)
    // .inject(atOnceUsers(1))
    UserActivity(userFeeder)
      .inject(atOnceUsers(1))
  ).protocols(
    httpProtocol
      //.proxy(Proxy("localhost", 3333))
  ).maxDuration(testDuration)

}
