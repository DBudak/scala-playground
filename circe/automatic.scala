/*
  Encoder[A] A -> Json
  Decoder[A] Json -> A
  
   It also provides instances for List[A], Option[A], and other generic types, but only if A has an Encoder instance.

  Can write custom decoders, refer to docs
*/


// ======== Encoding
import io.circe.syntax._

val intsJson = List(1, 2, 3).asJson


// ======== Decoding
intsJson.as[List[Int]]

//OR
import io.circe.parser.decode

decode[List[Int]]("[1, 2, 3]")

// ======== Automatic Derivation
import io.circe.generic.auto._, io.circe.syntax._

case class Person(name: String)
case class Greeting(salutation: String, person: Person, exclamationMarks: Int)

Greeting("Hey", Person("Chris"), 3).asJson