package hello.world

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useState
import slinky.native.{ScrollView, Text, View}

@react object ReactRouter {

  case class Props(redirPath: String)

  val component = FunctionalComponent[Props] { props =>

    View(
      Redir(props.redirPath, "/react-router"),
      Text("This is the Router page...")
    )
  }
}
