package controllers


import models.Location
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import scala.util.Random

/**
 * Created by jst on 04.09.14.
 */
object LocationController extends Controller {
  def list = Action {
    Ok(Json.toJson(Location.defaultLocations.sortBy(_.name)))
  }

  def random = Action {
    val locations = Location.defaultLocations
    val random = Random.shuffle(locations).head
    Ok(Json.toJson(random))
  }
}
