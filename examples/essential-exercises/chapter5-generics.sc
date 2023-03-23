sealed trait LinkedList[A] {

  def length(): Int = {
    this match {
      case Pair(hd, tl) => 1 + tl.length
      case End() => 0
    }
  }

  def contains(i: Int): Boolean = {
    this match {
      case Pair(hd, tl) => if (hd == i) true else tl.contains(i)
      case End() => false
    }
  }

  def apply(i: Int): Int = {
    this match {
      case Pair(hd, tl) => if (i == 0)
        hd
      else
        tl(i - 1)
      case End() => throw new Exception("Bad things happened")
    }
  }
}

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: Int, tail: LinkedList[A]) extends LinkedList[A]

// Tests
// length
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)
// contains
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.contains(3) == true)
assert(example.contains(4) == false)
assert(End().contains(0) == false)
// apply
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example(0) == 1)
assert(example(1) == 2)
assert(example(2) == 3)
assert(try {
  example(3)
  false
} catch {
  case e: Exception => true
})