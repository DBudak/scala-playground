// Write pure functions

// Do not use var and mutable types

// Async -> Future

// Arrays -> Lists

// Data -> final case class

// Polymorphism/Multi inheritance -> Traits

// Return null -> Option

// if else - > pattern matching

// Exception handling -> Try

// Use Tuples (Lists of different types)

// Use Sets (Lists of unique values without order)

// Use Maps (A collection of key -> value pairs)

// use .map to process values in containers like Option, Future, etc

// Use .map for iteration
val numbers = List(1,2,3)
val numbersMultipliedBy2 = numbers.map(n => n*2)

// Or use for yield
val numbers = List(1,2,3)

val numbersMultipliedBy2 = 
  for n <- numbers yield
    n*2


