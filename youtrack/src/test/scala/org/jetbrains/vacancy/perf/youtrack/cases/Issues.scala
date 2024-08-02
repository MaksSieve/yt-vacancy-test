package org.jetbrains.vacancy.perf.youtrack.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import org.jetbrains.vacancy.perf.youtrack.Utility.LoremIpsum

object Issues {
  val addIssue: HttpRequestBuilder =
    http("addIssue")
      .post("/api/issues")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .body(ElFileBody("requests/addIssue.json")).asJson
      .check(status is 200)

  val addComment: HttpRequestBuilder =
    http("addComment")
      .post("/api/issues/#{selectedIssueId}/comments")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .body(StringBody(
        s"""{
          |  "text": "${LoremIpsum.getRandomNumberOfWords(Range.inclusive(20, 30))}"
          |}""".stripMargin)).asJson
      .check(status is 200)

  val changeSummary: HttpRequestBuilder =
    http("changeSummary")
    .post("/api/issues/#{selectedIssueId}")
    .headers(Map(("Authorization", "Bearer #{token}")))
    .body(
      StringBody(
        s"""{
           |"summary": "${LoremIpsum.getRandomNumberOfWords(Range.inclusive(5, 10))}"
           |}""".stripMargin)
    ).asJson
    .check(status is 200)

  val searchAll: HttpRequestBuilder =
    http("searchAll")
      .get("/api/issues")
      .queryParam("fields", "id")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .check(status is 200)
      .check(jsonPath("$[*].id").findAll saveAs "issueIds")

  val randomSearch: HttpRequestBuilder =
    http("searchAll")
      .get("/api/issues?query=#{searchQuery}")
      .queryParam("fields", "id")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .check(status is 200)
      .check(jsonPath("$[*].id").findAll saveAs "issueIds")

  val openIssueToRead: HttpRequestBuilder =
    http("openIssueToRead")
      .get("/api/issues/#{selectedIssueId}")
      .queryParam("fields", "id,summary,links,comments")
      .headers(Map(("Authorization", "Bearer #{token}")))
      .check(status is 200)

}
