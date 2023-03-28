sealed trait Sum[+A, +B] {
  def flatMap[A1 >: A, C](f: B => Sum[A1, C]): Sum[A1, C] =
    this match {
      case Failure(v) => Failure(v)
      case Success(v) => f(v)
    }
}

final case class Failure[A](a: A) extends  Sum[A, Nothing]
final case class Success[B](a: B) extends Sum[Nothing, B]