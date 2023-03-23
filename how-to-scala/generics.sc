// Generics are abstractions over types
// Used when we can't specify but want to preserve the type
// [A] is a type parameter
// Using single uppercase letters is a convention
final case class BoxOfA[A](something: A)
def generic[A](in: A): A = in

// Generic ADT
sealed trait Calculation
final case class Success(result: Double) extends Calculation
final case class Failure(reason: String) extends Calculation
// to
sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

// Complex example, Invariant generic sum type: If A of type T is a B or C write
sealed trait A[T]
final case class B[T]() extends A[T]
final case class C[T]() extends A[T]

