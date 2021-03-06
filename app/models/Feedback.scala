package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._
import java.util.Date

/**
 * Created by jst on 04.09.14.
 */
case class Feedback(_id: BSONObjectID, username: String, comment: String, createdOn: Date) {

}

object Feedback {

  // Generates Writes and Reads for Feed and Location thanks to Json Macros
  implicit val feedbackFormat = Json.format[Feedback]
}