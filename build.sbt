ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "$name$"
  )

guardrailTasks in Compile := List(
  ScalaClient(file("petstore.yaml")),
  ScalaClient(file("github.yaml"), pkg = "com.example.clients.github"),
  ScalaClient(
    file("github.yaml"),
    pkg = "com.example.clients.github",
    encodeOptionalAs = codingOptional,
    decodeOptionalAs = codingRequiredNullable
  ),
  ScalaServer(
    file("myserver.yaml"),
    pkg = "com.example.server",
    tracing = true
  ),
  ScalaModels(file("myserver.yaml"), pkg = "com.example.models"),
  JavaClient(file("github.yaml"), pkg = "com.example.clients.github")
)
