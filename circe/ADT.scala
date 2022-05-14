sealed trait Event

case class Foo(i: Int) extends Event
case class Bar(s: String) extends Event
case class Baz(c: Char) extends Event
case class Qux(values: List[String]) extends Event

import cats.syntax.functor._
import io.circe.{ Decoder, Encoder }, io.circe.generic.auto._
import io.circe.syntax._

object GenericDerivation {
  implicit val encodeEvent: Encoder[Event] = Encoder.instance {
    case foo @ Foo(_) => foo.asJson
    case bar @ Bar(_) => bar.asJson
    case baz @ Baz(_) => baz.asJson
    case qux @ Qux(_) => qux.asJson
  }

  implicit val decodeEvent: Decoder[Event] =
    List[Decoder[Event]](
      Decoder[Foo].widen,
      Decoder[Bar].widen,
      Decoder[Baz].widen,
      Decoder[Qux].widen
    ).reduceLeft(_ or _)
}


//import GenericDerivation._
import io.circe.parser.decode

decode[Event]("""{ "i": 1000 }""")
// res0: Either[io.circe.Error, Event] = Right(value = Foo(i = 1000))

(Foo(100): Event).asJson.noSpaces
// res1: String = "{\"i\":100}"


// Or a mopre implicit approach
import GenericDerivation.{ decodeEvent => _, encodeEvent => _ }

object ShapesDerivation {
  import io.circe.shapes
  import shapeless.{ Coproduct, Generic }

  implicit def encodeAdtNoDiscr[A, Repr <: Coproduct](implicit
    gen: Generic.Aux[A, Repr],
    encodeRepr: Encoder[Repr]
  ): Encoder[A] = encodeRepr.contramap(gen.to)

  implicit def decodeAdtNoDiscr[A, Repr <: Coproduct](implicit
    gen: Generic.Aux[A, Repr],
    decodeRepr: Decoder[Repr]
  ): Decoder[A] = decodeRepr.map(gen.from)

}

//import ShapesDerivation._
import io.circe.parser.decode, io.circe.syntax._

decode[Event]("""{ "i": 1000 }""")
// res2: Either[io.circe.Error, Event] = Right(value = Foo(i = 1000))

(Foo(100): Event).asJson.noSpaces
// res3: String = "{\"i\":100}"