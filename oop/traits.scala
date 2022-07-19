// ------------------------------------- TRAITS

// Traits are interfaces from Java/mixins from JS/modules from Ruby
// Class can extend multiple Traits
// Traits are a way to express multi inheritance
// Sealed Trait enforces and compiler level that all classes extending it are in the same file with the Trait

trait Animal {
  def makeSound(mood: String): String
  def sleep = "animal sleeps"
  def move(speed: String): String
}

trait Nameable {
  def name: String
}

sealed trait Cute {
  def cutenessLevel: Int
}

class Cat extends Animal with Nameable with Cute {
  override val sleep = "loud snoring"
  val name = "Tom"
  val cutenessLevel = 10

  def makeSound(mood: String) = s"${mood} meow"

  def move(speed:String) = s"Moving ${speed}"
}

val tom = new Cat
println(tom.sleep)
println(tom.makeSound("gentle"))
println(tom.move("fast"))
println(tom.cutenessLevel)
println(tom.name)

// ===== [In Progress] Finding a dif btw sealed and normal trait
trait NormalTrait {
  def sayHello(s:String):String
  //def sayWhat(s:String):String in normal trait sayWhat needs to be implemented everywhere
}

case class C1() extends NormalTrait {
  def sayHello(s:String):String = "Hello"
}


case class C2() extends NormalTrait {
  def sayHello(s:String):String = "Hola"
  def sayGoodbye(s:String):String = "Adios!"
}

// Error, can't pattern match

def patternMatchNormal(o: NormalTrait): String = o match {
  case C1() => "C1"
  case C2() => "C2"
}


sealed trait SealedTrait {
  def sayHello(s:String):String
}

case class C3() extends SealedTrait {
  def sayHello(s:String):String = "Hello"
}

case class C4() extends SealedTrait {
  def sayHello(s:String):String = "Hola"
  def sayGoodbye(s:String):String = "Adios!"
}

def patternMatchSealed(o: SealedTrait): String = o match {
  case C3() => "C3"
  case C4() => "C4"
}
