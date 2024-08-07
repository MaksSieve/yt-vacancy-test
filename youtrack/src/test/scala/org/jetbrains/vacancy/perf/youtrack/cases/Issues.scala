package org.jetbrains.vacancy.perf.youtrack.cases

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import org.jetbrains.vacancy.perf.youtrack.Utility.LoremIpsum

object Issues {
  val addIssue: HttpRequestBuilder =
    http("addIssue")
      .post("/api/issues")
      .header("Authorization", "Bearer #{token}")
      .body(ElFileBody("requests/addIssue.json")).asJson
      .check(status is 200)

  val addComment: HttpRequestBuilder =
    http("addComment")
      .post("/api/issues/#{selectedIssueId}/comments")
      .header("Authorization", "Bearer #{token}")
      .body(StringBody(
        s"""{
          |  "text": "${LoremIpsum.getRandomNumberOfWords(Range.inclusive(20, 30))}"
          |}""".stripMargin)).asJson
      .check(status is 200)

  val changeDesc: HttpRequestBuilder =
    http("changeDesc")
    .post("/api/issues/#{selectedIssueId}")
    .header("Authorization", "Bearer #{token}")
    .body(
      StringBody(
        s"""{
           |"description": "${LoremIpsum.getRandomNumberOfWords(Range.inclusive(20, 30))}"
           |}""".stripMargin)
    ).asJson
    .check(status is 200)

  val issuesGetter: ChainBuilder =
    exec(
      session => {
        val ids = session("issueIds").as[Vector[String]]
        val issuesGetterBody = "[" + ids.map(id => s"""{"id": "$id"}""").mkString(",") + "]"
        session.set("issuesGetterBody", issuesGetterBody)
      }
    ).exec(http("issuesGetter")
      .post("/api/issuesGetter")
      .queryParam("fields", "id,idReadable,$type,attachments(id),canAddPublicComment,canUpdateVisibility,commentsCount,fields($type,hasStateMachine,id,isUpdatable,name,projectCustomField($type,bundle(id),canBeEmpty,emptyFieldText,field(fieldType(isMultiValue,valueType),id,localizedName,name,ordinal),id,isEstimation,isPublic,isSpentTime,ordinal,size),value($type,archived,avatarUrl,buildIntegration,buildLink,color(background,foreground,id),description,fullName,id,isResolved,localizedName,login,markdownText,minutes,name,presentation,ringId,text)),hasEmail,id,idReadable,project($type,id,isDemo,leader(id),name,plugins(helpDeskSettings(enabled)),ringId,shortName),reporter($type,avatarUrl,banBadge,banned,canReadProfile,email,fullName,id,isEmailVerified,isLocked,issueRelatedGroup(icon),login,name,online,profiles(general(trackOnlineStatus)),ringId,userType(id)),resolved,summary,tags(color(id),id,isUpdatable,isUsable,name,owner(id),query),transaction(authorId,timestamp),updated,updater($type,avatarUrl,banBadge,banned,canReadProfile,email,fullName,id,isEmailVerified,isLocked,issueRelatedGroup(icon),login,name,online,profiles(general(trackOnlineStatus)),ringId,userType(id)),visibility($type,implicitPermittedUsers($type,avatarUrl,banBadge,banned,canReadProfile,email,fullName,id,isEmailVerified,isLocked,issueRelatedGroup(icon),login,name,online,profiles(general(trackOnlineStatus)),ringId,userType(id)),permittedGroups($type,allUsersGroup,icon,id,name,ringId),permittedUsers($type,avatarUrl,banBadge,banned,canReadProfile,email,fullName,id,isEmailVerified,isLocked,issueRelatedGroup(icon),login,name,online,profiles(general(trackOnlineStatus)),ringId,userType(id))),voters(hasVote),votes,watchers(hasStar)")
      .header("Authorization", "Bearer #{token}")
      .body(StringBody("#{issuesGetterBody}")).asJson
      .check(status is 200)
      .check(jsonPath("$[*].id").findAll saveAs "issueIds")
      .check(jsonPath("$[*].idReadable").findAll saveAs "issueReadableIds")
    )

  val sortedIssues: HttpRequestBuilder =
    http("sortedIssues")
      .get("/api/sortedIssues?query=#{searchQuery}")
      .queryParam("query", "#{searchQuery}")
      .queryParam("fields", "tree(id,idReadable,matches,ordered,parentId,summaryTextSearchResult(highlightRanges(endOffset,startOffset),textRange(endOffset,startOffset)))")
      .queryParam("flatten", "true")
      .queryParam("skipRoot", 0)
      .queryParam("topRoot", 101)
      .queryParam("unresolvedOnly", false)
      .header("Authorization", "Bearer #{token}")
      .check(status is 200)
      .check(jsonPath("$.tree[*].id").findAll saveAs "issueIds")

  val searchAssist: HttpRequestBuilder =
    http("searchAssist")
      .post("/api/search/assist")
      .queryParam("fields", "caret,query,suggestions(caret,completionEnd,completionStart,description,group,matchingEnd,matchingStart,option)")
      .header("Authorization", "Bearer #{token}")
      .body(
        StringBody(
          """{
            |"query": "#{searchQuery}"
            |}""".stripMargin
        )
      ).asJson
      .check(status is 200)

  val openIssue: HttpRequestBuilder =
    http("openIssue")
      .get("/api/issues/#{selectedIssueId}")
      .queryParam("fields", "id,summary,links,comments")
      .header("Authorization", "Bearer #{token}")
      .check(status is 200)

  val addLink: HttpRequestBuilder =
    http("addLink")
      .post("/api/commands")
      .header("Authorization", "Bearer #{token}")
      .body(
        StringBody("""{"issues": [{"id": "#{selectedIssueId}"}], "query": "#{linkCommand}: #{issueIdToLink}"}""")
      ).asJson
      .check(status is 200)

  val addTag: HttpRequestBuilder =
    http("addTag")
      .post("/api/issues/#{selectedIssueId}")
      .header("Authorization", "Bearer #{token}")
      .body(StringBody("""{"id": "#{tagId}"}""")).asJson
      .check(status is 200)
}
