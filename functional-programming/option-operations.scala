// isDefined returns true if an optional instance has a value, false otherwise
// def isDefined: Boolean
Some(1).isDefined // true
None.isDefined // false
Some(None).isDefined // true
Some(None).flatten.isDefined // false

// The function isEmpty is the opposite of isDefined: it returns true if an optional instance is absent, false otherwise.
// def isEmpty: Boolean
Some(1).isEmpty // returns false
None.isEmpty // returns true
Some(None).isEmpty // false
Some(None).flatten.isEmpty // true

// getOrElse returns the optional value if present; otherwise, it will execute the provided default operation.
// def getOrElse(default: A): A
// safe way to get value out of Option
Some(1).getOrElse(-1) // returns 1
None.getOrElse(-1) // returns -1
Some(None).getOrElse(-1) // None
Some(None).flatten.getOrElse(-1) // -1

// find returns an optional value if its element satisfies a given predicate.
// def find(predicate: A => Boolean): Option[A]

Some(10).find(_ > 5) // returns Some(10)
Some(1).find(_ > 5) // returns None
None.find(_ > 5) // returns None

// The function exists combines find with isDefined: it returns true if the value is
// present and satisfies a given predicate, false otherwise.

// def exists(predicate: A => Boolean): Boolean
Some(10).exists(_ > 5) // returns true
Some(1).exists(_ > 5) // returns false
None.exists(_ > 5) // returns false