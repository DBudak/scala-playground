// Option should be used to represent nullable type in Scala. Using null is anti-pattern
// Type Option ensures that you deal with both presence and absence of the entity
// null is a language keyword that indicates a missing reference to an object

// Option is a sealed abstract class that can be implemented via defined list: Some and None
// [A] is a convernsion to use uppercase letters for type parameters

// Some is a case class of Option that represents presence of value
// None is object representation of Option and means absence of value
// Nothing is a subclass of every class and lives at the very bottom of class hierarchy
// Nothing is a type that can be associated with every other type


sealed abstract class Option[A]
case class Some[A](a: A) extends Option[A]
case object None extends Option[Nothing]

def filter (text: String, word: String): Option[String] = if (text contains word)  Some(text) else None

println(filter("A text", "text")) // Some(A text)
println(filter("A text", "snippet")) // None

def sqrt(n: Int): Option[Double] =
  if (n >= 0) Some(Math.sqrt(n)) else None

def sqrtOrZero(n: Int): Double =
  sqrt(n) match {
    case Some(result) => result
    case None => 0
  }

def greetings(message: Option[String]): String =
  message match {
    case Some(message) => s"${message}"
    case None => "Hello Scala"
  }

println(greetings(Some("Hi bob")))
println(greetings(None))

