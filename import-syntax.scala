import scala.concurrent.duration._ //everything
import scala.concurrent.duration.FiniteDuration //class FiniteDuration
import scala.concurrent.duration.FiniteDuration.create // method create
import scala.concurrent.duration.FiniteDuration.Inf // value Inf
import scala.io.{Source => src} //Import file Source and alias Src
import scala.math.{BigDecimal, BigInt} //import classes BigDecimal and BigInt

// Creating a package
package my.example.io

class Example {

  import scala.io.Source

  def read(fname: String) =
    Source.fromFile(fname).getLines().mkString("\n")

}