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

List(1.4, 2.5, 3.6).sum // 7.5

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
List(1, 2, 3).min
// There is also maxBy minBy with custom ordering rules.

// ------------------------------------- FILTERING

/*
  drop — The function drop takes an integer n as its parameter, and it creates a new
  list without its first n items. If the sequence has less than n elements, it returns the
  empty list.
*/
List(1,2,3).drop(1)
// Reverse of drop
List(1,2,3).take(1)

/*
dropWhile—For an instance of List[A], the method dropWhile creates a new list by
removing elements starting from its head until a given predicate A => Boolean is
respected.
 */
List(1,2,3,-1,-2,-3).dropWhile(_ < 2)
// reverse of dropWhile
List(1,2,3,-1,-2,-3).takeWhile(_ < 2)

/*
  filter — For an instance of List[A], the method filter takes a function of type A
  => Boolean as its parameter, and it returns a new list with all the elements that
  respect the predicate.
 */
List(1,2,3).filter(_ > 0)
// Boolean reverse of predicate
List(1,2,3).filterNot(_ > 0)

// ------------------------------------- REMOVE DUPLICATES

List(1,2,3,3,3).distinct

// ------------------------------------- SORTING

/*
  sorted — For an instance of List[A] where A is a type with a given order, the function returns a new sequence with its elements ordered accordingly. Let’s recall
  that type A has a given order if it has an implementation for Ordering[A].
 */
List(0.4, -2, 3).sorted

// You can combine multiple criteria by using a tuple. The first criteria in the tuple will have
// priority over the second one, and so on.
List(0.4, -2, 3).sortBy(i => -i)

List(1, 3, 2).reverse

// ------------------------------------- TO STRING

List("Hello", "Scala").mkString // HelloScala
List("Hello", "Scala").mkString("[", "-", "]") //  [Hello-Scala]

// ------------------------------------- GROUP BY

//def groupBy[K](f: A => K): Map[K, List[A]]
List(0,1,2).groupBy(_ % 2) // Returns Map(0 -> List(0,2), 1 -> List(1))
