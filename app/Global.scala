import models.Location
import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Logger
import play.libs.F.Function
import play.api.Play.current
import play.api.libs.ws._

object Global extends play.api.GlobalSettings {

  var host = "http://localhost:9000/"

  override def onStart(app: play.api.Application) {
    WS.url(host + "/locations").get().map {
      response =>
        // if no location entries in the DB available yet, create default entries
        if (response.json.as[JsArray].value.size == 0) {
          Logger.info("Creating default locations, as database is empty");
          Location.defaultLocations.foreach { location =>
            Logger.debug("About to create location: " + Json.toJson(location).toString());
            WS.url(host + "/location").post(Json.toJson(location));
          }
        } else {
          Logger.debug("Default locations already available in DB");
        }
    }
  }
}