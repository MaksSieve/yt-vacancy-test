package org.jetbrains.vacancy.perf.youtrack.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Users {

  val getMainPage: HttpRequestBuilder = http("GET /")
    .get("/")
    .check(status is 200)


  val createNewUser: String => HttpRequestBuilder = (authToken: String) => http("POST /hub/api/rest/users")
    .post("/hub/api/rest/users")
    .queryParamMap(Map("failOnPermissionReduce" -> true, "fields" -> ""))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/newUser.json")).asJson
    .check(status is 200)
    .check(header("Location").transform(s => s.split("""\/""").last).saveAs("userUUID"))

  val addUserToTeam: (String, String) => HttpRequestBuilder = (projectUUID: String, authToken: String) => http("POST /hub/api/rest/projects/$id/team/users")
    .post(s"/hub/api/rest/projects/${projectUUID}/team/users")
    .queryParamMap(Map(
      "fields" -> "total,guest,id,name,login,userType(id),profile(avatar(url),email(email,verified))"
    ))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/addToTeam.json")).asJson
    .check(status is 200)

  val generatePermToken: String => HttpRequestBuilder = (authToken: String) => http("generatePermToken")
    .post("/hub/api/rest/users/${userUUID}/permanenttokens")
    .queryParamMap(Map(
      ("failOnPermissionReduce", true),
      ("fields", "token")
    ))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/permToken.json")).asJson
    .check(status is 200)
    .check(jsonPath("$.token") saveAs "permToken")
}
