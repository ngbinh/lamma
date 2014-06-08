organization := "io.lamma"

name := "lamma"

version := "1.1"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.4", "2.11.1")

libraryDependencies += "junit" % "junit" % "4.11" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.9" % "test"  // we need to have this lib in order to run junit with sbt test

libraryDependencies += "com.google.guava" % "guava" % "17.0" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

// ============ publish / release related ================

publishMavenStyle := true

publishArtifact in Test := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

licenses := Seq("DO WHAT YOU WANT TO PUBLIC LICENSE, Version 1" -> url("https://github.com/maxcellent/lamma/blob/master/LICENSE"))

homepage := Some(url("https://github.com/maxcellent/lamma"))

pomExtra := (
  <scm>
    <url>git://github.com/maxcellent/lamma.git</url>
    <connection>scm:git://github.com/maxcellent/lamma.git</connection>
  </scm>
    <developers>
      <developer>
        <id>maxcellent</id>
        <name>Max Zhu</name>
        <url>http://lamma.io</url>
      </developer>
    </developers>
  )
