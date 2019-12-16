package hello.world

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useState
import slinky.native.{ScrollView, Text, View}

@react object Home {

  type Props = Unit

  val component = FunctionalComponent[Props] { _ =>

    View(
      Text("This is the home page...")
    )
  }
}
