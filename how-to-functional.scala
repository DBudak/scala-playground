// Write pure functions

// Use Lists instead of Arrays

// Use Tuples (Lists of different types)

// Use Sets (Lists of unique values without order)

// Use Maps (A collection of key -> value pairs)

// Use .map for iteration
val numbers = List(1,2,3)
val numbersMultipliedBy2 = numbers.map(n => n*2)

// Or use for yield
val numbers = List(1,2,3)

val numbersMultipliedBy2 = 
  for n <- numbers yield
    n*2


