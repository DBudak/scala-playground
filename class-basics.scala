// ------------------------------------- CLASSES

// Subclass - inheritance child
// Superclass - inheritance parent
// Abstract class - class where one or more methods do not have implementation
// Class can only have one superclass
// Multiple inheritance is expressed via Traits
// SYNTAX: class name { //methods here } Init via new name
// SYNTAX: class name(params){ //methods here } Init via new name(values)
// Overriding a method need to preserve the signature

// Inheritance is expressed with extends keyword
// SYNTAX: class name extends superclass {} Init via new name
// SYNTAX class name(parameters) extends superclass(parameters){} Init via new name(values)

// Scala has public (default/no keyword) private and protected
// Private accessible only within class
// Public accessible anywhere
// Protected accessible withing class and subclass

abstract class Animal(name: String) {
  def makeSound(mood: String): String
}

class Cat(val name: String = "Unknown") extends Animal(name) {
  def makeSound(mood: String = "Annoyed") = s"${mood} meow!"
}

val tom = new Cat(name="Tom")
println(tom.name)
println(tom.makeSound())

val unnamedCat = new Cat
println(unnamedCat.name)
println(unnamedCat.makeSound("Gentle"))

class HungryCat(name:String) extends Cat(name) {
  override def makeSound(mood: String) = s"Feed me now, human!"
}

val pixel = new HungryCat("Pixel")
println(pixel.makeSound("Any"))