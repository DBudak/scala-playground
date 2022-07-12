/*
 - use raw value
 - use Option(value) if there is a potential of null
 - use Try(Option) if you want to preserve the exception for Left
 - use Either(Option) if you want to preserve and define the error for Left
*/

// Prematurely unpacking Try or Option is not the Scala way
// Keep chaining methods on containers while you can

// =================== WHEN TO USE OPTION

// Use Option when there is a possibility of return value being null
def toInt(s: String): Option[Int] = {
    try {
        Some(Integer.parseInt(s.trim))
    } catch {
        case e: Exception => None
    }
}

// As opposed to 
import scala.util.control.Exception._
def toInt(s: String): Option[Int] = allCatch.opt(s.toInt)

// =================== WHEN TO USE TRY

// Use Try when you want a failure information instead of None
import scala.util.{Try,Success,Failure}
def divideXByY(x: Int, y: Int): Try[Int] = {
    Try(x / y)
}
/*
scala> divideXByY(1,1)
res0: scala.util.Try[Int] = Success(1)

scala> divideXByY(1,0)
res1: scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero)
*/

// Try has 
//      filter, flatMap, flatten, foreach, and map
//      get, getOrElse, and orElse
//      toOption, which lets you treat the result as an Option
//      recover, recoverWith, and transform, which let you gracefully handle Success and Failure results

// =================== WHEN TO USE EITHER

// Either is a more "freerun" implementation of Try
// Use Either when you need to define your own failure condition with custom message