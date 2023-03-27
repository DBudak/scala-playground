// Reduce and fold are similar
// Fold requires accumulator value, reduce does not
// Fold can convert to any type. Reduce to the same type or related type
// FoldLeft or FoldRight set the order of execution over collection
// FoldLeft and FoldRight accept any type, not just supertype
// Any function you care to write on an algebraic datatype can be written in terms of fold.

val oddNumbers: List[Int] = List(1,3,5,7,9,11)

// =========================================================== REDUCE

// A1 is a supertype of Int
// Signature of reduce:
/**
 * A function that reduces a List Of Int to type A1
 *
 * @param A1 - a super-type of Int
 * @param op - a function that takes in 2 parameters and returns of type A1
 * @returns - type A1
 */
// def reduceListOfIntegersToA1[A1 >: Int](f: (A1,A1) => A1): A1

def add(n1: Int, n2: Int): Int = n1+n2

val sum = oddNumbers.reduce(add)

// =========================================================== FOLD
// Fold can have different implementations and signatures
/**
 * A function that folds a List Of Int to type A1
 *
 * @param A1 - a super-type of Int
 * @param z  - the start value for accumulation.
 * @param op - a function that takes in 2 parameters and returns of type A1
 * @returns - type A1
 */
// def foldListOfIntegersToA1[A1 >: Int](z: A1)(f: (A1, A1) => A1): A1

val sum = oddNumbers.fold(0)(add)

// =========================================================== FOLDLEFT

// B has no relation to Int

// def foldLeft[B](z:B)(f: (B, Int) => B):B

val sum = oddNumbers.foldLeft(0)(add)