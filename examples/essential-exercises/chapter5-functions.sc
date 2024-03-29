sealed trait IntList {

  def sum: Int = this.fold(0, (hd, tl) => hd + tl )

  def product: Int = this.fold(0, (hd, tl) => hd * tl )

  def length: Int = this.fold(0, (hd, tl) => 1 + tl)

  def double: IntList = this.fold(End,(hd, tl) => Pair(hd * 2, tl) )

  def fold[A](acc: A, f: (Int, A) => A): A =
    this match {
      case End => acc
      case Pair(hd, tl) => f(hd, tl.fold(acc, f))
    }
}

case object End extends IntList
case class Pair(hd: Int, tl: IntList) extends IntList

sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  def length: Int =
    fold[Int](0, (_, tl) => 1 + tl)
  def product: Int =
    fold[Int](1, (hd, tl) => hd * tl)
  def sum: Int =
    fold[Int](0, (hd, tl) => hd + tl)
  def double: IntList =
    fold[IntList](End, (hd, tl) => Pair(hd * 2, tl))
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
