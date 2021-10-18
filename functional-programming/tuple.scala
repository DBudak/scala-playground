// When all you need is to group data without creating a specific representation for it, you can use tuples.
// In Scala, a tuple is a tool that allows you to quickly group data that can have a minimum
//  of 1 item and a maximum of 22.
// The compiler automatically decomposes a tuple containing only one element
// Pattern matching uses deconstructure

def lastDayAndMonthStats(): (Long, Long) = {
  val allStats = getStats()
  (allStats.lastDay, allStats.lastMonth)
}

val stats = lastDayAndMonthStats()
// stats refers to the entire tuple
val (lastDay, lastMonth) = lastDayAndMonthStats()
// lastDay refers to the first element of the tuple
// lastMonth refers to the second element of the tuple

// true because compiler auto decomposes one element Tuple
(1) == 1

val t = ("1", "2", "3")

t match {
  case ( _, _, c ) if c == "3" => "Three"
  case ( a,b,c ) => s"$a-$b-$c"
}

// can also use getters, syntax ._1 ._2 and so on

t._2 // "2"
