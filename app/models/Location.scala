package models

import play.api.libs.json.Json

/**
 * Created by jst on 04.09.14.
 */
case class Location(name: String, foodStyle: String) {

}

object Location {

  implicit val taskWrites = Json.writes[Location]
  implicit val taskReads = Json.reads[Location]

  val defaultLocations = List(Location("MoschMosch", "asian"),
    Location("Thai Express", "asian"),
    Location("DaSalvo", "italian"),
    Location("Vapiano", "italian"),
    Location("Zum Gutenberg", "greek"),
    Location("Red Chili", "asian"))

}