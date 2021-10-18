// ------------------------------------- ANONYMOUS FUNCTIONS

// SYNTAX: { (param) => expression }
// If receives only one param () can be omitted
// If params are used in a single instruction in order of declaration they can be replaced with _ and curly braces can be dropped

val sum = { (a: Int, b: Int) => a + b }

val prettyPrint = { s: String => s"${s} is now pretty" }

val sum2: (Int, Int) => Int = { (a, b) => a + b }

val sum3: (Int, Int) => Int =  _ + _

// ------------------------------------- PARTIAL FUNCTIONS

// Partial function is a function defined only for particular types
// SYNTAX: val nameOfFunc: PartialFunction[paramType, returnType] = {pattern matching}
// partial function can be converted to total function by returning Option

// Start writing your ScalaFiddle code here
val logp: PartialFunction[Int, Double] =
{ case x if x > 0 => Math.log(x) }

def log(x: Any): Option[Double] = x match {
  case x: Int => Some(Math.log(x))
  case _ => None
}

println(log(2.1)) // None


// ------------------------------------- FUNCTION COMPOSITION

// SYNTAX: secondFunc(firstFunc(param))
// SYNTAX: firstFun.andThen(secondFunc)
// Composition of partial function means that if first pf did not find match pass to second pf
// SYNTAX: pf1.orElse(pf2)(param)

val getLength: String => Int = _.size
val moreThanTwo: Int => Boolean = _ > 2

val moreThanTwoOfGetLength: String => Boolean = { s => moreThanTwo( getLength(s) ) }
println(moreThanTwoOfGetLength("yes")) // true
println(moreThanTwoOfGetLength("no")) //false

val moreThanTwoOfGetLength1: String => Boolean = getLength.andThen(moreThanTwo)
println(moreThanTwoOfGetLength1("yes")) // true
println(moreThanTwoOfGetLength1("no")) //false

val printInt: PartialFunction[Int, String] = { case x:Int if x > 0 => s"${x} is an Int > 0" }
val printDouble: PartialFunction[Int, String] = { case x:Int if x < 0 => s"${x} is an Int < 0" }

println(printInt.orElse(printDouble)(1))
