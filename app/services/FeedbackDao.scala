package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current
import models._
import models.Feedback._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.api.QueryOpts
import reactivemongo.core.commands.Count
import reactivemongo.bson.BSONObjectID
import play.api.Logger

/** A data access object for feedback backed by a MongoDB collection */
object FeedbackDao {

  /** The messages collection */
  private def collection = ReactiveMongoPlugin.db.collection[JSONCollection]("feedbacks")

  /**
   * Save a feedback.
   *
   * @return The saved feedback, once saved.
   */
  def save(feedback: Feedback): Future[Feedback] = {
    Logger.debug("Dao is saving: " + Json.toJson(feedback).toString())
    collection.save(feedback).map {
      case ok if ok.ok =>
        feedback
      case error => throw new RuntimeException(error.message)
    }
  }

  /**
   * Find all the feedback.
   *
   * @return All of the feedback.
   */
  def findAll(): Future[Seq[Feedback]] = {
    collection.find(Json.obj())
      .sort(Json.obj("username" -> -1))
      .cursor[Feedback]
      .collect[Seq]()
  }

  def remove(id: String): Future[reactivemongo.core.commands.LastError] = {
    Logger.debug(s"Removing fedback: [collection=feedbacks, id=$id]")
    collection.remove(Json.obj("_id" -> BSONObjectID(id)))
  }

  /** The total number of feedback */
  def count: Future[Int] = {
    ReactiveMongoPlugin.db.command(Count(collection.name))
  }

}