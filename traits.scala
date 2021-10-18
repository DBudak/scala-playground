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