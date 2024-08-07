package org.jetbrains.vacancy.perf.youtrack

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._
import org.galaxio.gatling.config.SimulationConfig._
import org.jetbrains.vacancy.perf.youtrack.scenarios._

class Debug extends Simulation {

 //  val apiAdminKey: String = getStringParam("apiAdminToken")
  val projectUUID: String = getStringParam("projectUUID")
  val projectId: String = getStringParam("projectId")


  setUp(
     UserActivity()
     .inject(atOnceUsers(1))
//    UserActivity(userFeeder)
//      .inject(atOnceUsers(1))
  ).protocols(
    httpProtocol
      .proxy(Proxy("localhost", 3333))
  )

}
