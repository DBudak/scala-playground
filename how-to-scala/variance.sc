// A type Foo[T] is invariant in terms of T, meaning that the types Foo[A] and Foo[B] are unrelated regardless
// of the relationship between A and B. This is the default variance of any generic type in Scala.

// A type Foo[+T] is covariant in terms of T, meaning that Foo[A] is a supertype of Foo[B] if A is a supertype of B.
// Most Scala collection classes are covariant in terms of their contents.

// A type Foo[-T] is contravariant in terms of T, meaning that Foo[A] is a subtype of Foo[B] if A is a supertype of B.
// The only example of contravariance that I am aware of is function arguments.

// We should only use covariant types where the container type is immutable.
// If the container allows mutation we should only use invariant types.

// If A of a covariant type T and a method f of A complains that T is used in a contravariant position,
// introduce a type TT >: T in f.

case class A[+T]() {
  def f[TT >: T](t: TT): A[TT] = ???
}

// ==================================== Type Bounds

// A MUST BE a SUBTYPE of T
// A <: T

// A MUST BE a SUPERTYPE of T
// A >: T

// Class will follow the supertype rules of the A
// Meaning Class[A] will be a supertype of Class[B] if A is a supertype of B
// Class[+A]

// Class will follow the reverse of inheritance rules of the A
// Meaning Class[A] will be a subtype of Class[B] if A is a supertype of B
// Class[-A]