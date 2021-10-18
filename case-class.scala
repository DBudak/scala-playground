// a case class is a class with an arbitrary number of parameters for which the compiler automatically adds ad hoc code
// can refer to it as product type
// for each param case class adds a getter function
// case class params are immutable
// copy function equivalent to initializing a new class
// copy function can receive only one param
// every class has the functions toString, hashCode, equals

// toString returns a string representation of class with has memory location
// case class returns class + data it contains

// equals: two classes are equal if they point to same memory location
// case class equal:  same type and structure is considered equal

// compiler auto generates companion object for case class with apply and unapply methods
// apply creates an instance of class without constructor
// unapply is used to decompose a class


case class Person(name: String, age: Int)

val tom = new Person("Tom", 25) // constructor
val jack = Person("Jack", 50) // apply
println(tom.name) // Tom

val mark = tom.copy( name = "Mark", age = tom.age + 1)
println(mark.age) // 26

val bob = mark.copy( name="Bob" )
println(bob.name) // Bob

println( tom.toString() ) // Person(Tom, 25)

Person.unapply(Person("John", 81))
// returns Some((Tom, 25))
// which has type Option[(String, Int)]

def welcome(person: Person): String = person match {
  case Person("Tom", _) => "Hello Tom"
  case Person(name, age) if age > 18 => s"Beer, ${name}?"
  case p @ Person(_, 18) => s"${p.name}, you are 18!" // @ binds entire class instance to a value to val p
  case Person(_,_) => "You are a Person!"
}

println(welcome(Person("Kate", 18))) // Beer, Kate?






