# BUILDS

# Scala projects can be built using Mavent, Ant, Gradle, sbt
# http4s is the library to set up REST
# sbt new http4s/http4s.g8 will get a scafolding of REST service

# OPERATION DETAILS

# Scala doesn't have operator overloading
# + - * / are actual methods on classes
# 1 + 2 is actually 1.+(2)
# array(0) is actually array.apply(0)
# :: is a method of RIGHT operand
# Any operation that ends with : is a right operand method. Anything else is left operand method

# IMMUTABLE VS MUTABLE COLLECTIONS

# Scala imports immutable collections by default
# For mutable equivalents: import scala.language.mutable
# example mutable.Set(1,"2")

# -> OPERATOR

# val map = Map(3)
# newMap = map + (1 -> "foo")
# 1 -> "foo" is really (1).->("foo")
# you invoke method -> on Int class with value 1 passing a string with value "foo"
# -> returns a two element Tuple containing key and value
# then tuple is passed to + method on class Map

# for yield

# Compiler transforms for yield into map call
val adjectives = List("One", "Two", "Three")
val nounsMap = adjectives.map(adj => adj + " Fish")
val nounsForYield =
  for adj <- adjectives yield
    adj + " Fish"

nounsMap == nounsForYield
