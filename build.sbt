import sbt.*
import Keys.*
import Versions.*

ThisBuild / name := "ScalaJS tools"
ThisBuild / scalaVersion := "3.6.4"

val lib = (project in file("lib"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "toolsjs",
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % laminarVersion,
      ("org.querki" %%% "jquery-facade" % jqueryVersion) cross CrossVersion.for3Use2_13 excludeAll (
        ExclusionRule(organization = "org.scala-js")
      ),
      "org.querki" %%% "bootstrap-datepicker-facade" % jqueryDatepickerVersion cross CrossVersion.for3Use2_13 excludeAll (
        ExclusionRule(organization = "org.scala-js"),
        ExclusionRule(organization = "org.querki"),
      ),
      "com.lihaoyi" %%% "upickle" % upickleVersion,
      "io.github.cquiroz" %%% "scala-java-time" % javaTimeVersion,
      "io.github.cquiroz" %%% "scala-java-time-tzdb" % javaTimeVersion
    )
  )
