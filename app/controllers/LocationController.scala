package controllers


import models.Location
import scala.concurrent.Future
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import scala.util.Random
import services.LocationDao
import reactivemongo.bson.BSONObjectID
import play.api.libs.concurrent.Execution.Implicits._

/**
 * Created by jst on 04.09.14.
 */
object LocationController extends Controller {

  /** Action to save a location */
  def saveLocation = Action.async(parse.json) { req =>
    req.body.validate[Location].map {
      location =>
        // `location` is an instance of the case class `models.Location`
        LocationDao.save(location).map(_ => Created)
    }.getOrElse(Future.successful(BadRequest("invalid json " + parse.json)))
  }

  def list = Action.async {
    for {
      locations <- LocationDao.findAll()
    } yield {
      val result = Ok(Json.toJson(locations))
      result
    }
  }
  /**
   * The location form for create location. This is separate from the database location since the form doesn't have an ID.
   */
  case class LocationForm(name: String, foodStyle: List[String], url: String) {
    def toLocation: Location = Location(BSONObjectID.generate, name, foodStyle, url)
  }

  implicit val locationFormFormat = Json.format[LocationForm]

  /** Action to create a message */
  def createLocation = Action.async(parse.json) { req =>
    Json.fromJson[LocationForm](req.body).fold(
      invalid => Future.successful(BadRequest("Bad location form")),
      form => LocationDao.save(form.toLocation).map(_ => Created)
    )
  }

  /** Action to save a location */
  def deleteLocation(locationId : String) = Action {
    LocationDao.remove(locationId)
    Ok("Location Deleted")
  }

  def random = Action {
    val locations = Location.defaultLocations
    val random = Random.shuffle(locations).head
    Ok(Json.toJson(random))
  }
}
