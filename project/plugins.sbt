// Liftweb
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

//Intellij Idea
resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0-SNAPSHOT")

// Jrebel

addSbtPlugin("fi.gekkio.sbtplugins" % "sbt-jrebel-plugin" % "0.10.0")
