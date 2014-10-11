import org.scalatestplus.play._
import models.Location

class LocationSpec extends PlaySpec {

  "Location" must {
    "return list of locations" in {
      val locationList = Location.defaultLocations
      locationList.size mustBe  > (0)
    }
    "contain at least one asian restaurant" in {
      val locationList = Location.defaultLocations
      locationList.count(_.foodStyle.contains("asia")) mustBe >= (1)
    }
  }

}