class Rational(n: Int, d: Int){
  require (d != 0)

  val denom = d
  val numer = n

  def this(n: Int) = this(n, 1)

  override def toString(): String = s"${n}/${d}"

  def +(that:Rational) = {

    // 1/2 + 4/3 = (1*3 + 4*2)/2*3
    val numerator = this.n * that.denom + that.numer * this.d
    val denumerator = this.d * that.denom
    Rational(numerator,denumerator)

  }

  def -(that:Rational) = {
    val numerator = this.n * that.denom - that.numer * this.d
    val denumerator = this.d * that.denom
    Rational(numerator,denumerator)
  }

  def *(that: Rational) = {
    Rational(this.n * that.numer, this.d * that.denom)
  }
}

extension (x:Int)
def + (y: Rational) = Rational(x) + y


println(Rational(1,2) + Rational(4,3))
println(Rational(1,2) - Rational(4,3))
println(Rational(1,2) * Rational(4,3))
println(5 + Rational(23,2))


//println(Rational(1,0))