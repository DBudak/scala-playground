// A type class is a trait with at least one type variable.
// The type variables specify the concrete types the type class instances are defined for.
// Methods in the trait usually use the type variables.
trait HtmlWriter[A] {
  def write(in: A): String
}
object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}
// Typeclass is a way to associate value to type
// Use typeclass to allow consumers to "extend the trait" for the class they can't modify
// The idea is to simply select a type class instance by type (done by the no-argument apply method) and then directly
//  call the methods defined on that instance.
object TypeClass {
  def apply[A](implicit instance: TypeClass[A]): TypeClass[A] =
    instance
}

/*
A type class is like a trait, defining an interface. However, with type classes we can:
 - plug in different implementations of an interface for a given class; and
 - implement an interface without modifying existing code.
 */

// Ordering is a Typeclass
// Typeclass instance
val minOrdering = Ordering.fromLessThan[Int](_ < _)
// Typeclass instance
val maxOrdering = Ordering.fromLessThan[Int](_ > _)
List(3, 4, 2).sorted(minOrdering)
// res0: List[Int] = List(2, 3, 4)
List(3, 4, 2).sorted(maxOrdering)
// res1: List[Int] = List(4, 3, 2)

// Passing minOrdering or MaxOrdering every time is inconvinient
// That's why typeclass instances are usually implicits
implicit val ordering = Ordering.fromLessThan[Int](_ < _)
// since List.sorted accepts implicit parameters
List(2, 4, 3).sorted
// res0: List[Int] = List(2, 3, 4)

/*
  When defining a type class instance, if
  - there is a single instance for the type; and
  - you can edit the code for the type that you are defining the instance for
  then define the type class instance in the companion object of the type.
 */

trait StrParser[T]{ def parse(s: String): T }
object StrParser{
  implicit object ParseInt extends StrParser[Int]{
    def parse(s: String) = s.toInt
  }
  implicit object ParseBoolean extends StrParser[Boolean]{
    def parse(s: String) = s.toBoolean
  }
  implicit object ParseDouble extends StrParser[Double]{
    def parse(s: String) = s.toDouble
  }

  implicit def ParseSeq[T](implicit p: StrParser[T]): StrParser[Seq[T]] = new StrParser[Seq[T]]{
    def parse(s: String) = s.split(',').toSeq.map(p.parse)
  }

  implicit def ParseTuple[T, V](implicit p1: StrParser[T], p2: StrParser[V]): StrParser[(T, V)] =
    new StrParser[(T, V)]{
      def parse(s: String) = {
        val Array(left, right) = s.split('=')
        (p1.parse(left), p2.parse(right))
      }
    }
}

def parseFromString[T](s: String)(implicit parser: StrParser[T]) = {
  parser.parse(s)
}
val myArgs = Array("123", "true", "456=false")

println(parseFromString[Int](myArgs(0)))              //123
println(parseFromString[Boolean](myArgs(1)))          //true
println(parseFromString[(Int, Boolean)](myArgs(2)))   // (456,false)


// Using implicit classes allows us to invoke type-class pattern on any type for which we have an adapter as if it was a built-in feature
trait HtmlWriter[A] {
  def write(in: A): String
}
object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}
implicit class HtmlOps[T](data: T) {
  def toHtml(implicit writer: HtmlWriter[T]) =
    writer.toHtml(data)
}

Person("John", "john@example.com").toHtml

