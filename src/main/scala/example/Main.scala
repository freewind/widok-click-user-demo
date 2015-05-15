package example

import org.widok._
import org.widok.html._

object Main extends PageApplication {

  val users = Seq(User("Jeff"), User("Lily"), User("Mike"), User("Sarah"))

  val selectedUser: Opt[User] = Opt()

  def view() = span(
    h1("Please select a user:"),
    users.map(user =>
      button(user.name)
        .css("user")
        .cssState(selectedUser.contains(user), "selected")
        .onClick(_ => selectedUser := user)
    )
  )

  def ready() {
    log("Page loaded.")
  }
}

case class User(name: String)
