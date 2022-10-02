ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "com.okayestprogrammer"

 assembly / assemblyMergeStrategy:= {
  case x if x.endsWith("module-info.class") => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

publishTo := Some(Resolver.file("file", new File("output")))

lazy val root = (project in file("."))
  .settings(
    name := "root"
  ).settings(addArtifact(artifact in (Compile, assembly), assembly).settings: _*)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
    case n if n.startsWith("Linux") => "linux"
    case n if n.startsWith("Mac") => "mac"
    case n if n.startsWith("Windows") => "win"
    case _ => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m=>
    "org.openjfx" % s"javafx-$m" % "11.0.1" classifier osName
)