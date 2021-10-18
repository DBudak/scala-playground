name := "hello-world-rest"
version := "0.1"
scalaVersion := "3.0.0"

val Http4sVersion = "0.23.5"

libraryDependencies ++= List(
  "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"      %% "http4s-dsl"          % Http4sVersion
)