// Map is an immutable data structure to store a set of keys, each of them associated with a value
/*
  A Map is a key-value data structure. It has a set of keys that are unordered and unique
  and that have values linked to each of them. Scala represents each key-value association,
  called entry, with a tuple. Its keys and values have specific types.
*/

//  When creating a map of type Map[K,V], you represent each of its entries using tuples of
//  type (K,V) and pass them to its constructor

// ------------------------------------- OPERATIONS
Map(1 -> "hi", 2 -> "scala") // Map(1 -> hi, 2 -> scala)
Map((1,"hi"), (2,"scala")) // Map(1 -> hi, 2 -> scala)

/*
  Scala offers an alternative syntax to create tuples. When creating a tuple, you can also
  use the -> operator. The following expressions are equivalent:
*/
("hello", "world") /* == */ "hello" -> "world"


