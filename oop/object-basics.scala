// ------------------------------------- OBJECTS

// Objects in Scala are NOT instance of a class
// Objects are singletons
// Objects cannot take parameters

// Companion object is an object with same name as class
// Both class and object have to be defined in same file
// Companion object and class share access to private members
// Companion objects are used to add static methods to classes
// Static methods act on a class rather than specific instance of it
// Companion objects can define apply methods to allow other ways to create instances of class in a addition to constructor

// Standalone object
object Singleton {
  val a: String = "a"
  val b: Int = 1
  val c: Boolean = false
}

println(Singleton.a)
println(Singleton.b)
println(Singleton.c)

class Cat(val name: String)

// Companion object
object Cat {
  def isAnimal(a: Cat) = s"yes, ${a.name} is an animal"

  def apply(): Cat = new Cat("Default Name")
}

val tom = new Cat("Tom")
println(Cat.isAnimal(tom))

val jerry = Cat.apply()
println(jerry.name)
