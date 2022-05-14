// Refer to library docs
// ======== Custom Key mappings
import io.circe.generic.extras._, io.circe.syntax._

implicit val config: Configuration = Configuration.default.withSnakeCaseMemberNames
@ConfiguredJsonCodec case class User(firstName: String, lastName: String)

User("Foo", "McBar").asJson