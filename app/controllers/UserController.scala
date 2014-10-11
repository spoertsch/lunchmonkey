package controllers

import models.Feedback
import scala.concurrent.Future
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import scala.util.Random
import services.FeedbackDao
import reactivemongo.bson.BSONObjectID
import play.api.libs.concurrent.Execution.Implicits._
import java.util.Date
import models.User

object UserController extends Controller {

  def init = Action {
    def uuid = java.util.UUID.randomUUID.toString
    def user : User = User(uuid)
    Ok(Json.toJson(user))
  }

}
