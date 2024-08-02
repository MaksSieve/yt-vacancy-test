package org.jetbrains.vacancy.perf.youtrack.scenarios

import com.opencsv.CSVWriter
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import org.jetbrains.vacancy.perf.youtrack.cases._

import java.io.{BufferedWriter, FileWriter}
import scala.util.Random

object AddUsers {
  def apply(authToken: String, projectUUID: String, numberOfUsers: Int): ScenarioBuilder =
    new AddUsers(authToken, projectUUID, numberOfUsers).scn
}

class AddUsers(authToken: String, projectUUID:String, numberOfUsers: Int) {

  val csvUserWriter = new CSVWriter(new BufferedWriter(new FileWriter("users.csv")))

  val userNameFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map("username" -> s"test-user-${Random.alphanumeric.take(10).mkString}")
  }

  val passwordFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map("password" -> s"${Random.alphanumeric.take(20).mkString}")
  }

  val scn: ScenarioBuilder = scenario("AddUsers Scenario")
    .repeat(numberOfUsers) {
      feed(userNameFeeder)
      .feed(passwordFeeder)
        .exec(Users.createNewUser(authToken))
        .exec(Users.generatePermToken(authToken))
        .exec(session => {
          println(session("userUUID").as[String])
          csvUserWriter.writeNext(Array(
            session("username").as[String],
            session("password").as[String],
            session("userUUID").as[String],
            session("permToken").as[String]
          ))

          session
        })
        .exec(Users.addUserToTeam(projectUUID, authToken))
    }
    .exec( session => {
      csvUserWriter.close()
      session
    })

}
