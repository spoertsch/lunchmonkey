import models.Location
import models.Location._
import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Logger
import play.libs.F.Function
import play.api.Play.current
import play.api.libs.ws._

import services.LocationDao

object Global extends play.api.GlobalSettings {

  override def onStart(app: play.api.Application) {
    Logger.info("starting up application");
    for {
      count <- LocationDao.count
    } yield {
      Logger.debug("Count of locations in application: " + count)
      if (count == 0) {
        Logger.info("Creating " + Location.defaultLocations.size + " default locations, as database is empty");
        for {
          location <- Location.defaultLocations
        } {
          Logger.debug("About to create location " + location.name)
          LocationDao.save(location)
        }
      }
    }
  }
}