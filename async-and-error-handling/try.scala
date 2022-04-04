// Use Try for error Handling instead of try catch
// Use .map to process or extract values
// Has a set of .glatMap .flatten

// Output: 
// Passed. Result: true
// Failed. Result: java.lang.Exception: Grade too low to pass exam
import scala.util.{Failure, Success, Try}

def examResult(grade: String): Try[Boolean] = grade match {
  case "A" | "B" | "C" => Success(true)
  case "D" | "E" | "F" => Failure(new Exception("Grade too low to pass exam"))
}

def outputExamResult(r: Try[Boolean]) = r match {
  case Success(b) => s"Passed. Result: ${b}"
  case Failure(ex) => s"Failed. Result: ${ex}"
}

println(outputExamResult(examResult("A")))
println(outputExamResult(examResult("F")))

// Use getOrElse to get the value out
// Output: 
// true
// Should have studied the subject!
val maybePassExamA = examResult("A").getOrElse("Should have studied the subject!")
val maybePassExamF = examResult("F").getOrElse("Should have studied the subject!")
println(maybePassExamA)
println(maybePassExamF)

// Use .isSuccess .isFailure to get boolean
// Output:
// false
// false
println(examResult("A").isFailure)
println(examResult("F").isSuccess)