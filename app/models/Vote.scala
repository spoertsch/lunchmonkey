package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._
import java.util.Date

/**
 * Created by jst on 04.09.14.
 */
case class Vote(username: String, positive: Boolean) {

}

object Vote {
  implicit val voteFormat = Json.format[Vote]
}