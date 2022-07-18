// Implicit parameter is a parameter that is auto filled when calling a function
// Implicit parameter CAN be passed explicitly
// Implicits are used to reduce the amount of code

implicit val n: Int = 365
def getStringCounter(s: String)(implicit n: Int): String = s"${s} : ${n}"

println(getStringCounter("Days since accident")) // Days since accident : 365
println(getStringCounter("Days since accident")(0)) // Days since accident : 0
