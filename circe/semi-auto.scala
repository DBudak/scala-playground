// ======== Semi-automatic Derivation
import io.circe._, io.circe.generic.semiauto._

case class Foo(a: Int, b: String, c: Boolean)

implicit val fooDecoder: Decoder[Foo] = deriveDecoder
implicit val fooEncoder: Encoder[Foo] = deriveEncoder

// OR VIA ANNOTATION

import io.circe.generic.JsonCodec, io.circe.syntax._

@JsonCodec case class Bar(i: Int, s: String)

Bar(13, "Qux").asJson
*

// OR MANUAL
import io.circe.{ Decoder, Encoder }

case class User(id: Long, firstName: String, lastName: String)

implicit val decodeUser: Decoder[User] =
  Decoder.forProduct3("id", "first_name", "last_name")(User.apply)


implicit val encodeUser: Encoder[User] =
  Encoder.forProduct3("id", "first_name", "last_name")(u =>
    (u.id, u.firstName, u.lastName)
  )
