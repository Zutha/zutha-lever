name := "Zutha Lever"

version := "0.0.1"

organization := "net.zutha"

scalaVersion := "2.10.2"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                  )

// Web plugin
seq(webSettings :_*)

// JRebel
seq(jrebelSettings: _*)

jrebel.webLinks <++= webappResources in Compile

jrebel.enabled := true

jrebel.classpath += file("target/scala-2.10/classes")


unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies <<= scalaVersion { v =>
  val liftVersion = "2.5.1"
  Seq(
    "org.scala-lang"     % "scala-reflect"      % v,
    "net.debasishg"     %% "redisreact"         % "0.1",
    "net.liftweb"       %% "lift-webkit"        % liftVersion           % "compile",
    "net.liftmodules"   %% "lift-jquery-module_2.5" % "2.4",
    "org.eclipse.jetty" % "jetty-webapp"        % "8.1.7.v20120910"     % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.scalatest"     %  "scalatest_2.10"     % "1.9.2"               % "test",
    "org.scalaz"        %% "scalaz-core"        % "7.0.3"
  )
}
