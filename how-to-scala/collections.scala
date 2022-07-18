// ================ HOW TO CHOOSE
// https://alvinalexander.com/scala/how-to-choose-collection-class-scala-cookbook/

/*
Qustions to ask:
    Should the sequence be indexed (like an array), allowing rapid access to any elements, or should it be implemented as a linked list?
    
    Do you want a mutable or immutable collection?

    Indexed:                Vector (Immutable)   | ArrayBuffer (Mutable)
    Linear(Linked List):    List (Immutable)     | ListBuffer (Mutable)
*/

// ================ METHODS

// Transforms:
// https://github.com/handsonscala/handsonscala/blob/v1/examples/4.2%20-%20Transforms/Transforms.sc
/*
    .map
    .filter
    .take
    .drop
    .slice
    .distinct
*/

// Queries:
// https://github.com/handsonscala/handsonscala/blob/v1/examples/4.3%20-%20QueriesAggregations/QueriesAggregations.sc
/*
    .find
    .exists
*/

// Aggregations:
// https://github.com/handsonscala/handsonscala/blob/v1/examples/4.3%20-%20QueriesAggregations/QueriesAggregations.sc
/*
    .mkString
    .foldLeft
    .groupBy
*/

// ================ METHODS PARAMETERS

/*
    if method needs something that can be iterated over use Seq[T]
    if methods needs something with index and iterable use IndexedSeq[T]
*/