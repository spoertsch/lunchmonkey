import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}


/**
 * Created by jst on 04.09.14.
 */
@RunWith(classOf[JUnitRunner])
class LocationControllerSpec extends Specification {
  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "return a list of locations" in new WithApplication{
      val locationList = route(FakeRequest(GET, "/locations")).get

      status(locationList) must equalTo(OK)
      contentType(locationList) must beSome.which(_ == "application/json")
    }

    "return a random location" in new WithApplication{
      val location = route(FakeRequest(GET, "/locations/random")).get

      status(location) must equalTo(OK)
      contentType(location) must beSome.which(_ == "application/json")
    }
  }
}
