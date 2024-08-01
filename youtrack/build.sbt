import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "org.jetbrains.vacancy.perf",
        scalaVersion := "2.13.14",
        version      := "0.1.0",
      ),
    ),
    name := "youtrack",
    libraryDependencies ++= gatling,
    libraryDependencies ++= gatlingPicatinny,
    libraryDependencies ++= janino,
    libraryDependencies ++= opencsv,
      scalacOptions ++= Seq (
        "-encoding",
        "UTF-8",
        "-Xfatal-warnings",
        "-deprecation",
        "-feature",
        "-unchecked",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
        "-language:postfixOps"
      ),
  )
