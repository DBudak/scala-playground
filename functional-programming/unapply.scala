/*
  The unapply function is a static method defined in the companion object of a class. It is
  complementary to apply to extract information from a class instance. When declaring a
  case class, the compiler automatically adds an unapply method to its companion object.
  A pattern matching construct uses it to determine which parameters it should consider.
  You cannot use pattern on a class’s parameters if it doesn’t have an unapply method in its
  companion object.
*/

// Unapply is destructure , returns Tuple of params

object Drink {
  def unapply(drink: Drink): Option[(Double, Double)] = {
    val nutritionFacts = drink.loadNutritionFacts()
    Some((nutritionFacts.saturatedFat, nutritionFacts.sugars))
  }
}