// hof is a func that receives a func as param
// hof can have default params

// SYTAX: def name(funcParam): returnType = expression
// funcParam is name:type => returnType
// funcParam is name:type => returnType = defaultImplementation

def hof (s: String, predicate: Char => Boolean = { _ => true } ): Int = s.count(predicate)

def countAll(s: String): Int = hof(s, _ => true)
def countLetters(s: String): Int = hof(s, _.isLetter)
def countDigits(s: String): Int = hof(s, _.isDigit)

println(countAll("foo"))      // 3
println(countLetters("foo"))  // 3
println(countDigits("foo"))   // 0

def hofReturn (s: Char):  Char => Boolean = _ => s.isLetter

println(hofReturn('a')('9')) // true
println(hofReturn('9')) // <function1>

sealed trait Mode
case object Length extends Mode
case object Letters extends Mode
case object Digits extends Mode

def predicateSelector(mode: Mode): Char => Boolean =
  mode match {
    case Length => _ => true
    case Letters => _.isLetter
    case Digits => _.isDigit
  }

val text = "This is my Text Example"
hof(text, predicateSelector(Length)) // count of all chars
hof(text, predicateSelector(Letters)) // count of upper letters