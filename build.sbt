lazy val jlineVersion = "3.5.1"

lazy val root = (project in file("."))
  .settings(
    name := "grpc-tool",
    libraryDependencies:=Seq(
      "org.jline" % "jline" % jlineVersion,
      "org.jline" % "jline-terminal" % jlineVersion,
      "org.jline" % "jline-reader" % jlineVersion,
      "org.typelevel"%%"cats-core"%"1.0.0-MF",
      "org.typelevel"%% "cats-effect" % "0.4"
    )
  )
