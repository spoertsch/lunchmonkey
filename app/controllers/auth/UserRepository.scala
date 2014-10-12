package controllers.auth

trait UserRepository {
  def findUser(username: String): Option[User]
}

case class InMemoryUserRepository(
    users: Seq[User] = Seq(User("timo", "timo")))
  extends UserRepository {
  override def findUser(username: String): Option[User] = users.find(_.username == username)
}

case class User(username: String, passwordInClearText: String)

class Login(userRepository: UserRepository) {

  def withUser[A](username: String, password: String)
                 (authUser: User => A)
                 (authError: String => A): A = {
    userRepository.findUser(username) match {
      case Some(user) if user.username == password => authUser(user)
      case Some(user) => authError(user.username)
      case None => authError(username)
    }

  }

}

