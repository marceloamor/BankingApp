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
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.14"   //AnyFunSuite -- most common
val flatSpec = "org.scalatest" %% "scalatest-flatspec" % "3.2.14" % Test
val funSpec="org.scalatest" %% "scalatest-funspec" % "3.2.14" % Test
val wordSpec="org.scalatest" %% "scalatest-wordspec" % "3.2.14" % Test
val freeSpec = "org.scalatest" %% "scalatest-freespec" % "3.2.14" % Test


libraryDependencies ++=Seq(scalaLogging, utilControl, reflect, xml, scalaTest, flatSpec, funSpec, wordSpec, freeSpec)