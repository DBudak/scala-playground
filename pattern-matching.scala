// ------------------------------------- PATTERN MATCHING

// Pattern matching is advanced switch/case
// In addition to normal switch/case it can act on types and perform boolean logic

// SYNTAX: valueToMatch match {}
// Possible matches:
//  case value => expression match const value
//  case name => expression match and bind value to name to use in expression
//  case name: type => expression match an instance of type and bind to name
//  case name if condition => expression match if true
//  case _:type => expression match anything of type without binding

// if the type of the valueToMatch is a sealed trait and pattern matching does not cover ALL cases of a trait compiler will give a warning

def dayOfWeek(n: Int): String = n match{
  case 1 => "Sun"
  case 2 => "Mon"
  case 3 => "Tue"
  case _ => "Im not made of time to implement all days of the week"
}

def allPatternMatchExamples(param: Any) = param match {
  case posInteger: Integer if posInteger > 0 => "Integer > 0" //  case name if condition
  case double: Double => s"${double} is Double"  // case name: type => expression
  case "foo" => "bar" // case value => expression
  case _:String => "A random string that is not foo" // case _:type => expression
  case obj => obj.toString //  case name => expression
}
