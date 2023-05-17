// Implicit parameter is a parameter that is auto filled when calling a function
// Implicit parameter CAN be passed explicitly
// Implicits are used to reduce the amount of code
// We can tag any val, var, object or zero-argument def with the implicit keyword
// An implicit value must be declared within a surrounding object, class, or trait.
// The compiler will signal an error if there is any ambiguity in which implicit value should be used.

implicit val n: Int = 365
def getStringCounter(s: String)(implicit n: Int): String = s"${s} : ${n}"

println(getStringCounter("Days since accident")) // Days since accident : 365
println(getStringCounter("Days since accident")(0)) // Days since accident : 0

// Implicit Scope

// The compiler searches the implicit scope when it tries to find an implicit value to supply as an implicit parameter.
// First looks within local scope, then companion objects for local scope

// Implicit Classes allow  add new functionality to an existing class without editing its source code
// For example adding new method to String
// if we tag our class with the implicit keyword, we give Scala the ability to insert the constructor call automatically into our code:
implicit class ExtraStringMethods(str: String) {
  val vowels = Seq('a', 'e', 'i', 'o', 'u')

  def numberOfVowels =
    str.toList.filter(vowels contains _).length
}

// Instead of
new ExtraStringMethods("the quick brown fox").numberOfVowels
// You now have
"the quick brown fox".numberOfVowels

// Only a single implicit class will be used to resolve a type error. The compiler will not look to construct a chain of
// implicit classes to access the desired method.


