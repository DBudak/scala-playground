// ======================================== Generic PRODUCT Types
// Generic PRODUCT Types solve the "variable can be A or B type" problem

case class Pair[A, B](one: A, two: B)
val pair = Pair("hi", 2)

// Tuples are a tool to implement Generic Product Types
Tuple1("hi", 1)

// Parameter in can be A or B type
def tuplized[A, B](in: (A, B)) = in._1

// Tuples are usually pattern matched
(1, "a") match {
  case (a, b) => a + b
}

// ======================================== Generic SUM Type
// Scala’s standard library has the generic sum type Either for two cases, but it does not have types for more cases.

// Can't do below without :Any
def intOrString(input: Boolean) =
  if(input == true) 123 else "abc"

// So we have to introduce new type
sealed trait Sum[A, B]
final case class Left[A, B](v: A) extends Sum[A, B]
final case class Right[A, B](v: B) extends Sum[A, B]

def intOrString(input: Boolean): Sum[Int, String] =
  if(input == true) {
    Left[Int, String](123)
  } else {
    Right[Int, String]("abc")
  }
