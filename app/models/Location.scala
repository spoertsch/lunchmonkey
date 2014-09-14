package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._

/**
 * Created by jst on 04.09.14.
 */
case class Location(_id: BSONObjectID, name: String, foodStyle: String, url: String) {

}

object Location {

  // Generates Writes and Reads for Feed and Location thanks to Json Macros
  implicit val locationFormat = Json.format[Location]

  val defaultLocations = List(Location(BSONObjectID.generate, "MoschMosch", "asian", "http://moschmosch.com/sites/default/files/mosch_herbst_goetheplatz_kw33-14_0.pdf"),
    Location(BSONObjectID.generate, "Thai Express", "asian", ""),
    Location(BSONObjectID.generate, "DaSalvo", "italian", ""),
    Location(BSONObjectID.generate, "Vapiano", "italian", "http://de.vapiano.com/de/menue/pasta/"),
    Location(BSONObjectID.generate, "Zum Gutenberg", "greek", ""),
    Location(BSONObjectID.generate, "Red Chili", "asian", "http://www.redchilli-thai.de/speisen/mittagstisch"),
    Location(BSONObjectID.generate, "Awake", "various", "https://de-de.facebook.com/cafeawake"),
    Location(BSONObjectID.generate, "Extrablatt", "various", "http://www.cafe-extrablatt.com/cms/front_content.php?idcat=956&standort_id=60"),
    Location(BSONObjectID.generate, "Proviantmagazin", "various", "http://www.proviant-magazin.de/?essen_und_trinken&mittagstisch"),
    Location(BSONObjectID.generate, "Rewe", "food store", ""),
    Location(BSONObjectID.generate, "GBC Döner", "döner", ""),
    Location(BSONObjectID.generate, "KPC Döner", "döner", ""),
    Location(BSONObjectID.generate, "Subway", "sandwich", ""),
    Location(BSONObjectID.generate, "Metzger GBC", "butcher", ""),
    Location(BSONObjectID.generate, "Currywurst GBC", "imbiss", ""),
    Location(BSONObjectID.generate, "Imbiss", "imbiss", "http://www.fe-mainz.de/index.php?s=Imbiss"),
    Location(BSONObjectID.generate, "Gasthof Grün", "various", "http://www.gasthofgruen.de/mittagstisch/"),
    Location(BSONObjectID.generate, "Baron", "various", "http://www.baron-mainz.de/restaurant/speisen/mittagstisch/"),
    Location(BSONObjectID.generate, "Eisgrub", "german", ""),
    Location(BSONObjectID.generate, "Pizzeria Bretzenheim", "italian", ""),
    Location(BSONObjectID.generate, "Bullys Burger", "burger", "http://www.bullys-burger.de/")
  )

}