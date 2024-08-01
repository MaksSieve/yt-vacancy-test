import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.10.5" % Test)

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq("org.galaxio" %% "gatling-picatinny" % "0.16.0")
  lazy val janino: Seq[ModuleID]           = Seq("org.codehaus.janino" % "janino" % "3.1.12")
  lazy val opencsv: Seq[ModuleID] = Seq("com.opencsv" % "opencsv" % "5.9")
}
