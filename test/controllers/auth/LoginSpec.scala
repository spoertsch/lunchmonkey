package controllers.auth

import org.scalatest.{MustMatchers, WordSpec}
import org.scalatest.mock.MockitoSugar

import org.mockito.Mockito._

class LoginSpec extends WordSpec with MustMatchers with MockitoSugar {

  "A Login" must {

    val username = "test"
    val password = "test"
    val user = User(username, password)

    "succeed or users with correct passwords" in {
      val userRepo = mock[UserRepository]
      doReturn(Some(user)).when(userRepo).findUser(username)

      val login = new Login(userRepo)

      login.withUser(username, password) {
        user =>
          user mustBe user
      } {
        username =>
          fail("password was correct and user must be authenticated")
      }
    }

    "fail if a wrong password was provided" in {
      val userRepo = mock[UserRepository]
      doReturn(Some(user)).when(userRepo).findUser(username)

      val login = new Login(userRepo)

      login.withUser(username, "invalid password") {
        user =>
          fail("password was incorrect and user must not been authenticated")
      } {
        username =>
          username mustBe username
      }
    }

    "fail if a user doesn't exist" in {
      val userRepo = mock[UserRepository]
      doReturn(None).when(userRepo).findUser(username)

      val login = new Login(userRepo)

      login.withUser(username, password) {
        user =>
          fail("user doesn't exist")
      } {
        username =>
          username mustBe username
      }
    }

  }

}
