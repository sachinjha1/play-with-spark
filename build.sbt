name := "play-with-spark"

version := "1.0"

scalaVersion := "2.11.11"

val sparkVersion = "1.6.1"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % sparkVersion
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % sparkVersion

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}