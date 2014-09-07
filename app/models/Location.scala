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
    Location("Red Chili", "asian"),
    Location("Awake", "various"),
    Location("Extrablatt", "various"),
    Location("Proviantmagazin", "various"),
    Location("Rewe", "food store"),
    Location("GBC Döner", "döner"),
    Location("Subway", "sandwich"),
    Location("Metzger GBC", "butcher"),
    Location("Currywurst GBC", "imbiss"),
    Location("Imbiss", "imbiss"),
    Location("Pizzeria Bretzenheim", "italian"))

}