package org.jetbrains.vacancy.perf.youtrack.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Issues {
  val addIssue: HttpRequestBuilder =
    http("addIssue")
      .post("/api/issues")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .body(ElFileBody("requests/addIssue.json")).asJson
      .check(status is 200)

  val addComment =
    http("addComment")
      .post("/api/issue/#{issueId}/comments")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .body(StringBody(
        """
          |{
          |  "text": "Disregard the previous comment. The problem still requires investigation.",
          |}
          |""".stripMargin)).asJson
      .check(status is 200)

  val searchAll =
    http("searchALl")
      .get("/api/issues")
      .queryParam("fields", "id,summary,description")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .check(status is 200)
      .check(jsonPath(".") saveAs "issues")
}
