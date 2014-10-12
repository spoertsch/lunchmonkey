package controllers.auth

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

object LoginController extends Controller {

  val userLogin = new Login(InMemoryUserRepository())

  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  def loginConfirm = Action { implicit request =>
    loginForm.bindFromRequest().fold(
      hasErrors => {
        BadRequest(views.html.login(hasErrors))
      },
      loginData => {
        userLogin.withUser(loginData.username, loginData.password) {
          user =>
            Redirect(controllers.routes.Application.index())
              .withNewSession
              .addingToSession(("username" -> loginData.username))
        } {
          username =>
            BadRequest(views.html.login(loginForm))
        }

      }
    )

  }

  case class LoginInfo(username: String, password: String)

  def loginForm = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText
    )(LoginInfo.apply)(LoginInfo.unapply)
  )

}
