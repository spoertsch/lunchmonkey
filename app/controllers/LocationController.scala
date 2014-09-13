package controllers


import models.Location
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import scala.concurrent.Future
import reactivemongo.api.Cursor
import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import org.slf4j.{LoggerFactory, Logger}
import play.api.mvc.{Action, Controller}
import scala.util.Random

/**
 * Created by jst on 04.09.14.
 */
object LocationController extends Controller with MongoController {

  //private final val logger: Logger = LoggerFactory.getLogger(classOf[LocationController])

  /*
   * Get a JSONCollection (a Collection implementation that is designed to work
   * with JsObject, Reads and Writes.)
   * Note that the `collection` is not a `val`, but a `def`. We do _not_ store
   * the collection reference to avoid potential problems in development with
   * Play hot-reloading.
   */
  def collection: JSONCollection = db.collection[JSONCollection]("locations")

  def createLocation = Action.async(parse.json) {
    request =>
      request.body.validate[Location].map {
        location =>
          // `location` is an instance of the case class `models.Location`
          collection.insert(location).map {
            lastError =>
              // logger.debug(s"Successfully inserted with LastError: $lastError")
              Created(s"Location Created")
          }
      }.getOrElse(Future.successful(BadRequest("invalid json " + parse.json)))
  }

  def list = Action.async {
    // let's do our query
    val cursor: Cursor[Location] = collection.
      find(Json.obj("active" -> true)).
      // sort them by creation name
      sort(Json.obj("name" -> -1)).
      // perform the query and get a cursor of JsObject
      cursor[Location]

    // gather all the JsObjects in a list
    val futureLocationsList: Future[List[Location]] = cursor.collect[List]()

    // transform the list into a JsArray
    val futureLocationsJsonArray: Future[JsArray] = futureLocationsList.map { locations =>
      Json.arr(locations)
    }
    // everything's ok! Let's reply with the array
    futureLocationsJsonArray.map {
      locations =>
        Ok(locations(0))
    }
  }

  def random = Action {
    val locations = Location.defaultLocations
    val random = Random.shuffle(locations).head
    Ok(Json.toJson(random))
  }
}
