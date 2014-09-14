package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current
import models._
import models.Location._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.api.QueryOpts
import reactivemongo.core.commands.Count
import reactivemongo.bson.BSONObjectID
import play.api.Logger

/** A data access object for locations backed by a MongoDB collection */
object LocationDao {

  /** The messages collection */
  private def collection = ReactiveMongoPlugin.db.collection[JSONCollection]("locations")

  /**
   * Save a location.
   *
   * @return The saved location, once saved.
   */
  def save(location: Location): Future[Location] = {
    Logger.debug("Dao is saving: " + Json.toJson(location).toString())
    collection.save(location).map {
      case ok if ok.ok =>
        // EventDao.publish("location", location)
        location
      case error => throw new RuntimeException(error.message)
    }
  }

  /**
   * Find all the locations.
   *
   * @return All of the locations.
   */
  def findAll(): Future[Seq[Location]] = {
    collection.find(Json.obj())
      .sort(Json.obj("name" -> -1))
      .cursor[Location]
      .collect[Seq]()
  }

  def remove(id: String): Future[reactivemongo.core.commands.LastError] = {
    Logger.debug(s"Removing location: [collection=locations, id=$id]")
    collection.remove(Json.obj("_id" -> BSONObjectID(id)))
  }

  /** The total number of locations */
  def count: Future[Int] = {
    ReactiveMongoPlugin.db.command(Count(collection.name))
  }

}