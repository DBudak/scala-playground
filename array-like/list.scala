// The type List allows you to represent an immutable ordered sequence of elements.
/*
  The class List has one type parameter: all the
  elements in the list must be of the same kind. When defining a list, Scala will
  infer its type parameter by selecting the closest type compatible with all its elements.
 */

// ------------------------------------- IMPLEMENTATION
package scala
sealed abstract class List[A] {
  def head: A
  def tail: List[A]
}
case object Nil extends List[Nothing] {
  def head = throw new NoSuchElementException("head of empty list")
  def tail: List[Nothing] =
    throw new UnsupportedOperationException("tail of empty list")
}
case class ::[A](head: A, tail: List[A]) extends List[A]

// Example
val contacts = List(1, 2)

// ------------------------------------- OPERATIONS

// def size: Int
List(1,2).size

// def isEmpty: Boolean
List(1,2).isEmpty

// def nonEmpty: Boolean
List(1,2).nonEmpty

// def contains(elem: A): Boolean
List(1,2).contains(3)

// def exists(p: A => Boolean): Boolean
List(1,2).exists(_ > 1)

// def count(p: A => Int): Int
List(1,2,3).count(_ > 1)

// The : is always facing the List
// Prepend is much faster and is independent on the size

// Append to list
val moreContacts = contacts :+ 3

// Prepend to list
val prependContacts = 0 +: moreContacts

// Merge
val merged = contacts ++ prependContacts

println(moreContacts) // List(1, 2, 3)
println(prependContacts) // List(0, 1, 2, 3)
println(merged) // List(1, 2, 0, 1, 2, 3)

// ------------------------------------- MAP FLATTEN FOR COMPREHENSION

// map(f: A => B): List[B]
// flatten: List[A]
def multiplyByTwo(l: List[Int]): List[Int] =
  l.map(num => num*2).flatten

// flatMap(f: A => List[B]): List[B]
def getNumbers(contacts: List[Contact]): List[ContactNumber] =
  contacts.flatMap(_.numbers)

println(multiplyByTwo(merged)) // List(2, 4, 0, 2, 4, 6)

def selectByEmails(contacts: List[Contact],
                    emails: List[String]): List[Contact] = for {
  contact <- contacts
  email <- emails
  if contact.email.exists(_.equalsIgnoreCase(email))
  } yield contact

// ------------------------------------- ELEMENT SELECTIONS

/*
  apply — The method apply takes the index of the element in a sequence to return.
  In Scala, indexes always start from zero: the first element will have index 0, the
  second one index 1, and so on. It is an impure function because it throws IndexOutOfBoundsException
  if no item is available for the given index.
 */

// def apply(n: Int): A
List(0,1,2).apply(2) // 2
List(0,1,2).apply(3) // it throws an IndexOutOfBoundsException

/*
  headOption—The function head and its equivalent apply(0) are impure functions
  as they throw exceptions for empty sequences.
*/

// def headOption: Option[A]
List(0,1,2).headOption

/*
  Pick the first element that satisfies a condition
*/

//def find(p: A => Boolean): Option[A]
List(0,1,2).find(_ <= 1)

/*
  max — For an instance of List[A] where A is a type with a given ordering, the
  method max returns the maximum element in the sequence. In Scala, you define
  an ordering for a type A by providing an implementation for Ordering[A] (you’ll
  learn how to specify a custom order for any given type when discussing the
  implicit language feature). When the list is empty, it throws an UnsupportedOperationException.
  In Scala, many types have a predefined order: String, Int,
  BigDecimal, Char, Byte, and Boolean are some of them.
*/

List(1, 2, 3).max