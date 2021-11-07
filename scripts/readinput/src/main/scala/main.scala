/*

scala 2

package main

object Hello extends App {
  println("Hello I am Scala 2")
}
 */
@main def m() = {
  val input = List("Hi my name is", "What?", "My name is", "Who?")
  printGreeting()
  printInput(input)
  printAllInput(input)
}

def printGreeting() = println("Hello I am Scala 3")

def printInput(input: List[String]) = println("Your Input is " + input(0) + " :)")

def printAllInput(input: List[String]) = input.map(i => {
  println(i)
  if(i == "Who?") println("Slim Shady")
})


