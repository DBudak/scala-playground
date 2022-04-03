// Future is JS Promise
// Future needs an execution context
// Future runs in a separate thread
// Future is an async Try
// CANNOT USE pattern matching

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

// Simple example.
// Output: "Text"
Future(10/2).onComplete {
  case Success(n) if n > 5 => println(n)
  case Success(n) => println("Text")
  case Failure(ex) => println(s"Exception: ${ex}")
}

// Simple example failed. 
// Output: Future Failed. Exception: java.lang.ArithmeticException: / by zero
Future(10/0).onComplete {
  case Success(n) if n > 5 => println(n)
  case Success(n) => println("Text")
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

// Method Example
// Output: 100
def asyncDivNumber(
a: Int,
b: Int
): Future[Int] = Future(a/b)

asyncDivNumber(100,1).onComplete {
  case Success(n) if n > 5 => println(n)
  case Success(n) => println("Text")
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

// onComplete returns Unit so any result it 'returns' is lost
// Output: nothing
asyncDivNumber(10,0).onComplete {
  case Success(n) if n > 5 => n
  case Success(n) => "Text"
  case Failure(ex) => ex
}

// To mutate a Future value or return something while processing future use .map
// Output: foo bar
Future("foo").map{s => s"${s} bar"}.onComplete{ 
  case Success(s) => println(n)
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

// If Future fails map does nothing. Future returns Failure
// Output: Future Failed. Exception: java.lang.ArithmeticException: / by zero
Future(10/0).map{n => s"${n} bar"}.onComplete{ 
  case Success(n) => println(s)
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

// Or with methods
// Output: This world is changed forver
def mutateFutureString(
  f:Future[String]
) = { f.map{s => s"${s} is changed forver"}}

def printFutureResult(
  f: Future[String]
) = f.onComplete{ 
  case Success(s) => println(s)
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

printFutureresult(mutateFutureString(Future("This world")))

// If you get Future[Future[T]] us .flatten or .flatMap