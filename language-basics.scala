// -------------------------------------  VALUES

// Immutable variables
// Should be always used instead of variables when possible
// Defined with keyword val
// SYNTAX: val name:type = expression
// Examples
val a:Int = 1
// a=5  // Invalid mutating reassignment
println(a)

// -------------------------------------  VARIABLES

// Mutable variables
// Defined with keyword var
// SYNTAX: var name:type = expression
var b:Int = 2
b=3 // valid mutating reassignment
println(b)

// -------------------------------------  STRING INTERPOLATION
val c = "Fox"
println(s"Fire${c}")

// -------------------------------------  CONDITIONALS

if(a == b) {
  println(s"$a = $b")
} else if (a > b) {
  println(s"$a > $b")
} else {
  println("else statement")
}

if(a == b) println(s"$a = $b")
else if (a > b) println(s"$a > $b")
else println("else statement")

// ------------------------------------- LOOPS

// while (condition) expression
var i = 1
while(i < 5) {
  println(i)
  i += 1
}

// for (name <- iterable) expression
for (i <- 1 to 5) { // inclusive Range. exclusive Range keyword is until
  println(i)
}

List(1,2,3).foreach(i => println(i))

// -------------------------------------  EXCEPTIONS

// Any class that extends java.lang.Exception is an exception

try {
  throw new Exception("BOMB")
} catch {
  case ex: Exception => println("Caught exception")
}

// -------------------------------------  EQUALITY

// Scala 2 can copare different types with warning
"true" == true //true

// Scala 3 only strict equality, above no longer compiles

// -------------------------------------  SEMICOLON

// Scala infers semicolons
// A line ending is treated as a semicolon unless
// a) Line ends with a word that would not be legal as end of statement
// b) Next line begins with word that can't start statement
// c) Line ends while inside () or []

// -------------------------------------  OPERATORS

// All operators are really methods
// Operators can be
// infix
2 + 1
// prefix
-2
// postfix
s.toLowerCase

// -------------------------------------  SHORT CIRCUIT

// && and || short circuit
// if you don't want to short circuit use & and |
