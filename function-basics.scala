// ------------------------------------- FUNCTIONS

// Scala compiler does not infer function parameter types
// Return type HAS to be explicitly set for recursive functions
// take zero or more parameters
// may not return a value
// implicit return of last expression

// SYNTAX: def name (params): return = expression
def isEven(n: Int): Boolean = {
  n % 2 == 0
}
var z = 1
for (z <- 1 until 6) {
  println(isEven(z))
}

// Param default
def greeting(name: String, greeting: String = "Hello") = s"${greeting} ${name}"
println(greeting("Bob"))

// Calling a function can refer to parameters by name (order then does not matter)
def div(a: Int, b:Double): Double = a / b
// println(div(5.3, 2)) // error
println(div(b=5.3, a= 2))

// ??? explicitly tells the compiler that implementation is missing
def myFunc() = ???

def func1 = ???
def func2() = ???
def func3(a:Int): Int = ???
def func4(a: Int) = ???

// if implementation is missinbg implicitly provide return type since compiler cant infer it
def func5(a: Int): Int
//def func6(a: Int) error

// SYNTAX FOR LITERAL
// (a: type) => a
