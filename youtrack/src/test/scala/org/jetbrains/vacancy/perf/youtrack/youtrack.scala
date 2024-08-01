package org.jetbrains.vacancy.perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.jetbrains.vacancy.perf.youtrack.Utility.debugMemoryAndOpts
import org.galaxio.gatling.config.SimulationConfig._
package object youtrack {

  if (sys.env.get("DEBUG").exists(_.equalsIgnoreCase("true")))
    debugMemoryAndOpts()

  // common http protocol params (eg headers, checks)
  val httpProtocol = http
    .baseUrl(
      baseUrl,
    )                                                                                // Here is the root for all relative URLs, located in simulation.conf file, or -DbaseUrl="" passed to test param
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .disableFollowRedirect

}
