package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._
import java.util.Date

/**
 * Created by jst on 04.09.14.
 */
case class User(username: String) {

}

object User {
  implicit val userFormat = Json.format[User]
}