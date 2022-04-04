// To handle multiple Futures use for-comprehension
// Below code will concurently execute all Futures
// If any fail, whole chain Fails and returns Failure
// If need parallel execution there are methods on Future instead (read 417 of pink Scala book)


// Outputs: Merchant(1,Doe,28)
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

case class Merchant(id: Int, lastName: String, age: Int)

def getLastName(id: Int) = Future("Doe")

def getAge(id: Int) = Future(28)

def printFutureResult(
  f: Future[Any]
) = f.onComplete{ 
  case Success(s) => println(s)
  case Failure(ex) => println(s"Future Failed. Exception: ${ex}")
}

// CORE METHOD HERE
def getMerchant(
  id: Int
): Future[Merchant] = for {
  lastName <- getLastName(id)
  age <- getAge(id)
} yield Merchant(id, lastName, age)

printFutureResult(getMerchant(1))