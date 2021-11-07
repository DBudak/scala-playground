# COMMANDS

sbt exit # gracefully terminate
sbt about # version
sbt compile # compiles code
sbt run # compile and run
sbt help # man
sbt clean # delete any files created during compile
sbt reload # re-eval the config provided to project
sbt new # create a project using Giter8 template
sbt console # start REPL
sbt ~compile # hot reload

# Giter8 is a framework of templates for skeleton projects

# PROJECT STRUCTURE

# build.sbt - library dependencies
# PROJECT: - sbt configs
#  build.properties - sbt version
#  plugins.sbt - sbt plugins
#  target - sbt source
# SRC: - your project source
#  MAIN: - prod source
#   SCALA
#   JAVA
#   RESOURCES - static files
#  TEST:
#   SCALA
#   RESOURCES - static test files
# TARGET - compiled code