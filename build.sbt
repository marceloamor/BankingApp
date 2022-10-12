ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "BankingApp1"
  )

val scalaLogging="com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
val utilControl="org.scala-sbt" %% "util-control" % "1.7.2"
val reflect = "org.scala-lang" % "scala-reflect" % "2.13.10"
val xml = "org.scala-lang.modules" %% "scala-xml" % "2.1.0"



libraryDependencies ++=Seq(scalaLogging, utilControl, reflect, xml)