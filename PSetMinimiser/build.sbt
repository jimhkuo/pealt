import AssemblyKeys._

assemblySettings

test in assembly := {}

mainClass in assembly := Some("peal.minimise.Main")

name := "PSetMinimiser"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"