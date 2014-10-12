package controllers

import java.util.Date

import controllers.auth.{UserAuthentication, UserRequest}
import models.Feedback
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, Controller}
import reactivemongo.bson.BSONObjectID
import services.FeedbackDao

import scala.concurrent.Future

object FeedbackController extends Controller with UserAuthentication {

  /** Action to save a feedback */
  def saveFeedback = Action.async(parse.json) { req =>
    req.body.validate[Feedback].map {
      feedback =>
        // `feedback` is an instance of the case class `models.Feedback`
        FeedbackDao.save(feedback).map(_ => Created)
    }.getOrElse(Future.successful(BadRequest("invalid json " + parse.json)))
  }

  def list = isAuthenticated(parse.anyContent) { implicit request: UserRequest[AnyContent] =>
    for {
      feedbacks <- FeedbackDao.findAll()
    } yield {
      val result = Ok(Json.toJson(feedbacks))
      result
    }
  }
  /**
   * The feedback form for create feedback. This is separate from the database feedback since the form doesn't have an ID.
   */
  case class FeedbackForm(username: String, comment: String) {
    def toFeedback: Feedback = Feedback(BSONObjectID.generate, username, comment, new Date())
  }

  implicit val feedbackFormFormat = Json.format[FeedbackForm]

  /** Action to create a message */
  def createFeedback = Action.async(parse.json) { req =>
    Json.fromJson[FeedbackForm](req.body).fold(
      invalid => Future.successful(BadRequest("Bad feedback form")),
      form => FeedbackDao.save(form.toFeedback).map(_ => Created)
    )
  }

  /** Action to save a feedback */
  def deleteFeedback(feedbackId : String) = Action {
    FeedbackDao.remove(feedbackId)
    Ok("Feedback Deleted")
  }
}
