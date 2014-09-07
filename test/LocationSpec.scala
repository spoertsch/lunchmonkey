import org.scalatest._
import models.Location

class LocationSpec extends FlatSpec with Matchers {

  "Location" should "return list of locations" in {
    val locationList = Location.defaultLocations
    locationList.size should be > (0)

  }

  it should "contain at least one asian restaurant" in {
    val locationList = Location.defaultLocations
    locationList.count(_.foodStyle == "asian") should be >= (1)
  }

}