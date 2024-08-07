package org.jetbrains.vacancy.perf.youtrack.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Users {

  val getMainPage: HttpRequestBuilder = http("GET /")
    .get("/")
    .check(status is 200)


  val createNewUser: String => HttpRequestBuilder = (authToken: String) => http("createNewUser")
    .post("/hub/api/rest/users")
    .queryParamMap(Map("failOnPermissionReduce" -> true, "fields" -> ""))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/newUser.json")).asJson
    .check(status is 200)
    .check(header("Location").transform(s => s.split("""\/""").last).saveAs("userUUID"))

  val addUserToTeam: (String, String) => HttpRequestBuilder = (projectUUID: String, authToken: String) =>
    http("addUserToTeam")
    .post(s"/hub/api/rest/projects/${projectUUID}/team/users")
    .queryParamMap(Map(
      "fields" -> "total,guest,id,name,login,userType(id),profile(avatar(url),email(email,verified))"
    ))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/addToTeam.json")).asJson
    .check(status is 200)

  val generatePermToken: String => HttpRequestBuilder = (authToken: String) => http("generatePermToken")
    .post("/hub/api/rest/users/#{userUUID}/permanenttokens")
    .queryParamMap(Map(
      ("failOnPermissionReduce", true),
      ("fields", "token")
    ))
    .headers(Map(("Authorization", "Bearer " + authToken)))
    .body(ElFileBody("requests/permToken.json")).asJson
    .check(status is 200)
    .check(jsonPath("$.token") saveAs "permToken")

  val me: HttpRequestBuilder =
    http("me")
      .get(s"/api/users/me")
      .queryParam(
        "fields", "avatarUrl,email,featureFlags(enabled,id),fullName,guest,id,issueRelatedGroup(icon),login,profiles(appearance(compactMode,exceptionsExpanded,expandChangesInActivityStream,expandNavigation,firstDayOfWeek,lastUsedColor,linksPanelExpanded,modalSidebarWidth,naturalCommentsOrder,showLinksUnderDescription,showPropertiesOnTheLeft,showSimilarIssues,showToolbar,showTooltips,uiPickerSeen,uiTheme,useAbsoluteDates,useMarkdownEditor,useSimplifiedUI,useSummaryInIssueLinks),general(dateFieldFormat(dateNoYearPattern,datePattern,dayPattern,id,monthPattern,pattern,presentation),id,locale(community,id,language,locale,name),searchContext(fqFolderId,id,isUpdatable,issuesUrl,name,query,shortName),star(id),suggestBatchSilentApply,suggestSavedSearchAsContext,timezone(dstHistory(offsets,untils),id,presentation),trackOnlineStatus,useMarkdown),helpdesk(commentSignature,helpdeskFolder(id),isAgent,isReporter),issuesList(issueListView(detailLevel,treeView),priorityVisible,projectsExpanded,savedSearchesExpanded,showSidebar,sortTextByRelevance,tagsExpanded,unresolvedIssuesOnly),notifications(autoWatchOnComment,autoWatchOnCreate,autoWatchOnFieldSet,autoWatchOnUpdate,autoWatchOnVote,disabledDirect,disabledSubscription,disabledSystem,duplicateClusterNotificationsEnabled,emailBlockReason,emailBlocked,emailNotificationsEnabled,inboxNotificationsEnabled,mailboxIntegrationNotificationsEnabled,mentionNotificationsEnabled,mutedThreads(id,idReadable,summary),notifyOnOwnChanges,showSystem,showUnreadOnly,usePlainTextEmails),teamcity(fixInBuildNotificationsEnabled,isCCCNotificationsEnabled),timetracking(isTimeTrackingAvailable,periodFieldPattern,periodFormat(id)),zendesk(notificationsEnabled)),ringId,userType(id),widgets(appIconPath,appId,appName,collapsed,extensionPoint,id,indexPath,name)"
      )
      .queryParam("ignoreLicenseErrors", true)
      .headers(Map(("Authorization", "Bearer " + "#{token}")))
      .check(status is 200)

  val recentIssues: HttpRequestBuilder =
    http("recentIssues")
      .get(s"/api/users/me/recent/issues")
      .queryParam(
        "fields", "issue(id,reporter(issueRelatedGroup(@permittedGroups),id,ringId,login,name,email,isEmailVerified,guest,fullName,avatarUrl,online,banned,banBadge,canReadProfile,isLocked,userType(id)),resolved,updated,created,unauthenticatedReporter,fields(value(id,minutes,presentation,name,description,localizedName,isResolved,color(@color),buildIntegration,buildLink,text,issueRelatedGroup(@permittedGroups),ringId,login,email,isEmailVerified,guest,fullName,avatarUrl,online,banned,banBadge,canReadProfile,isLocked,userType(id),allUsersGroup,icon,teamForProject(name,shortName)),id,$type,hasStateMachine,isUpdatable,projectCustomField($type,id,field(id,name,ordinal,aliases,localizedName,fieldType(id,presentation,isBundleType,valueType,isMultiValue)),bundle(id,$type),canBeEmpty,emptyFieldText,hasRunningJob,ordinal,isSpentTime,isPublic),searchResults(id,textSearchResult(highlightRanges(@textRange),textRange(@textRange))),pausedTime),project(id,ringId,name,shortName,iconUrl,template,pinned,archived,isDemo,organization(),hasArticles,team(@permittedGroups),fieldsSorted,restricted,plugins(timeTrackingSettings(id,enabled),helpDeskSettings(id,enabled,defaultForm(uuid,title)),vcsIntegrationSettings(hasVcsIntegrations),grazie(disabled))),visibility($type,implicitPermittedUsers(@user),permittedGroups(@permittedGroups),permittedUsers(@user)),tags(id,name,color(@color)),votes,voters(hasVote),watchers(hasStar),usersTyping(timestamp,user(@user)),canUndoComment,idReadable,summary),id,pinned,date;@user:id,ringId,login,name,email,isEmailVerified,guest,fullName,avatarUrl,online,banned,banBadge,canReadProfile,isLocked,userType(id);@permittedGroups:id,name,ringId,allUsersGroup,icon,teamForProject(name,shortName);@color:id,background,foreground;@textRange:startOffset,endOffset"
      )
      .queryParam("ignoreLicenseErrors", true)
      .headers(Map(("Authorization", "Bearer " + "#{token}")))
      .check(status is 200)
}
