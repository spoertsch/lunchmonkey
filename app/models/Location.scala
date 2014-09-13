package models

import play.api.libs.json.Json

/**
 * Created by jst on 04.09.14.
 */
case class Location(name: String, foodStyle: String, url: String, active: Boolean = true) {

}

object Location {

  // Generates Writes and Reads for Feed and Location thanks to Json Macros
  implicit val userFormat = Json.format[Location]

  val defaultLocations = List(Location("MoschMosch", "asian", "http://moschmosch.com/sites/default/files/mosch_herbst_goetheplatz_kw33-14_0.pdf"),
    Location("Thai Express", "asian", ""),
    Location("DaSalvo", "italian", ""),
    Location("Vapiano", "italian", "http://de.vapiano.com/de/menue/pasta/"),
    Location("Zum Gutenberg", "greek", ""),
    Location("Red Chili", "asian", "http://www.redchilli-thai.de/speisen/mittagstisch"),
    Location("Awake", "various", "https://de-de.facebook.com/cafeawake"),
    Location("Extrablatt", "various", "http://www.cafe-extrablatt.com/cms/front_content.php?idcat=956&standort_id=60"),
    Location("Proviantmagazin", "various", "http://www.proviant-magazin.de/?essen_und_trinken&mittagstisch"),
    Location("Rewe", "food store", ""),
    Location("GBC Döner", "döner", ""),
    Location("KPC Döner", "döner", ""),
    Location("Subway", "sandwich", ""),
    Location("Metzger GBC", "butcher", ""),
    Location("Currywurst GBC", "imbiss", ""),
    Location("Imbiss", "imbiss", "http://www.fe-mainz.de/index.php?s=Imbiss"),
    Location("Gasthof Grün", "various", "http://www.gasthofgruen.de/mittagstisch/"),
    Location("Baron", "various", "http://www.baron-mainz.de/restaurant/speisen/mittagstisch/"),
    Location("Eisgrub", "german", ""),
    Location("Pizzeria Bretzenheim", "italian", ""),
    Location("Bullys Burger", "burger", "http://www.bullys-burger.de/")
  )

}