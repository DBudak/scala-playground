// Typeclass is a way to associate value to type
// Use typeclass to allow consumers to "extend the trait" for the class they can't modify

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

