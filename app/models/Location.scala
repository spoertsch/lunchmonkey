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
    Location(BSONObjectID.generate, "Thai Express", "asian", "http://www.thai-express.de/speisekarten/thaiexpress-speisekarte-franziskanerstr.pdf"),
    Location(BSONObjectID.generate, "DaSalvo", "italian", "http://www.pizzeriadasalvo.de/speisekarte-pizza.html"),
    Location(BSONObjectID.generate, "Vapiano", "italian", "http://de.vapiano.com/de/menue/pasta/"),
    Location(BSONObjectID.generate, "Zum Gutenberg", "greek", "http://www.zum-gutenberg.de/Mittagskarte.pdf"),
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
    Location(BSONObjectID.generate, "Eisgrub", "german", "http://www.eisgrub.de/"),
    Location(BSONObjectID.generate, "Plaka", "greek", "http://www.mainzrestaurants.de/restaurants_in_mainz_und_umgebung/plaka.php"),
    Location(BSONObjectID.generate, "Pizzaboy", "delivery, italian", "http://www.pizzaboy.de/pizzaboy-Mainz-Mombach/"),
    Location(BSONObjectID.generate, "Burger King", "fast food, burger", ""),
    Location(BSONObjectID.generate, "Mc Donalds", "fast food, burger", ""),
    Location(BSONObjectID.generate, "Döner Bretzenheim", "döner", ""),
    Location(BSONObjectID.generate, "Asia World", "asia, buffet", "http://www.asia-world-mainz.de/Speisenkarte.pdf"),
    Location(BSONObjectID.generate, "Mainzer Kebab Haus", "döner", "http://www.mainzrestaurants.de/imbisse_in_mainz_und_umgebung/mainzer_kebap_haus.php"),
    Location(BSONObjectID.generate, "Alex", "various", "https://www.dein-alex.de/speisekarte-mainz"),
    Location(BSONObjectID.generate, "Aposto Mainz", "italian", "https://www.aposto.eu/mainz/restaurant/mittagstisch"),
    Location(BSONObjectID.generate, "Maredo", "steak, various", "http://www.maredo.de/essen-trinken/mittagstisch.html"),
    Location(BSONObjectID.generate, "Cubo Negro", "burger, various", "http://www.cubonegro.de/restaurant.php"),
    Location(BSONObjectID.generate, "Da Luigi", "italian", "https://de-de.facebook.com/pages/Pizzeria-da-Luigi/265400060194481"),
    Location(BSONObjectID.generate, "Bullys Burger", "burger", "http://www.bullys-burger.de/")
  )

}