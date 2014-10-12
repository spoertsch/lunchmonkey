package controllers.auth

import play.api.mvc._

import scala.concurrent.Future

class UserRequest[A](
    val username: Option[String],
    request: Request[A])
  extends WrappedRequest[A](request)

trait UserAuthentication {
  self: Controller =>

  def isAuthenticated[A](p: BodyParser[A])(f: UserRequest[A] => Future[Result]) = {
    Action.async(p) { request: Request[A] =>
      val usernameOpt = request.session.get("username")
      usernameOpt match {
        case Some(username) =>
          f(new UserRequest(Some(username), request))
        case None =>
          Future.successful {
            //Redirect(controllers.auth.routes.LoginController.login())
            Unauthorized
          }
      }

    }
  }
}

