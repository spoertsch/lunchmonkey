package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._

/**
 * Created by jst on 04.09.14.
 */
case class Location(_id: BSONObjectID, name: String, foodStyle: String, url: String, votes: Option[List[Vote]]) {

}

object Location {

  // Generates Writes and Reads for Feed and Location thanks to Json Macros
  implicit val locationFormat = Json.format[Location]

  val defaultLocations = List(Location(BSONObjectID.generate, "MoschMosch", "asian", "http://moschmosch.com/sites/default/files/mosch_herbst_goetheplatz_kw33-14_0.pdf", null),
    Location(BSONObjectID.generate, "Thai Express", "asian", "http://www.thai-express.de/speisekarten/thaiexpress-speisekarte-franziskanerstr.pdf", null),
    Location(BSONObjectID.generate, "DaSalvo", "italian", "http://www.pizzeriadasalvo.de/speisekarte-pizza.html", null),
    Location(BSONObjectID.generate, "Vapiano", "italian", "http://de.vapiano.com/de/menue/pasta/", null),
    Location(BSONObjectID.generate, "Zum Gutenberg", "greek", "http://www.zum-gutenberg.de/Mittagskarte.pdf", null),
    Location(BSONObjectID.generate, "Red Chili", "asian", "http://www.redchilli-thai.de/speisen/mittagstisch", null),
    Location(BSONObjectID.generate, "Awake", "various", "https://de-de.facebook.com/cafeawake", null),
    Location(BSONObjectID.generate, "Extrablatt", "various", "http://www.cafe-extrablatt.com/cms/front_content.php?idcat=956&standort_id=60", null),
    Location(BSONObjectID.generate, "Proviantmagazin", "various", "http://www.proviant-magazin.de/?essen_und_trinken&mittagstisch", null),
    Location(BSONObjectID.generate, "Rewe", "food store", "", null),
    Location(BSONObjectID.generate, "GBC Döner", "döner", "", null),
    Location(BSONObjectID.generate, "KPC Döner", "döner", "", null),
    Location(BSONObjectID.generate, "Subway", "sandwich", "", null),
    Location(BSONObjectID.generate, "Metzger GBC", "butcher", "", null),
    Location(BSONObjectID.generate, "Currywurst GBC", "imbiss", "", null),
    Location(BSONObjectID.generate, "Imbiss", "imbiss", "http://www.fe-mainz.de/index.php?s=Imbiss", null),
    Location(BSONObjectID.generate, "Gasthof Grün", "various", "http://www.gasthofgruen.de/mittagstisch/", null),
    Location(BSONObjectID.generate, "Baron", "various", "http://www.baron-mainz.de/restaurant/speisen/mittagstisch/", null),
    Location(BSONObjectID.generate, "Eisgrub", "german", "http://www.eisgrub.de/", null),
    Location(BSONObjectID.generate, "Plaka", "greek", "http://www.mainzrestaurants.de/restaurants_in_mainz_und_umgebung/plaka.php", null),
    Location(BSONObjectID.generate, "Pizzaboy", "delivery, italian", "http://www.pizzaboy.de/pizzaboy-Mainz-Mombach/", null),
    Location(BSONObjectID.generate, "Burger King", "fast food, burger", "", null),
    Location(BSONObjectID.generate, "Mc Donalds", "fast food, burger", "", null),
    Location(BSONObjectID.generate, "Döner Bretzenheim", "döner", "", null),
    Location(BSONObjectID.generate, "Asia World", "asia, buffet", "http://www.asia-world-mainz.de/Speisenkarte.pdf", null),
    Location(BSONObjectID.generate, "Mainzer Kebab Haus", "döner", "http://www.mainzrestaurants.de/imbisse_in_mainz_und_umgebung/mainzer_kebap_haus.php", null),
    Location(BSONObjectID.generate, "Alex", "various", "https://www.dein-alex.de/speisekarte-mainz", null),
    Location(BSONObjectID.generate, "Aposto Mainz", "italian", "https://www.aposto.eu/mainz/restaurant/mittagstisch", null),
    Location(BSONObjectID.generate, "Maredo", "steak, various", "http://www.maredo.de/essen-trinken/mittagstisch.html", null),
    Location(BSONObjectID.generate, "Cubo Negro", "burger, various", "http://www.cubonegro.de/restaurant.php", null),
    Location(BSONObjectID.generate, "Da Luigi", "italian", "https://de-de.facebook.com/pages/Pizzeria-da-Luigi/265400060194481", null),
    Location(BSONObjectID.generate, "Bullys Burger", "burger", "http://www.bullys-burger.de/", null)
  )

}