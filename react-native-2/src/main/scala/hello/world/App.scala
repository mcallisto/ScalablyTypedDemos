package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.Hooks._
import slinky.native._

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.Dynamic.literal

import typings.antdDashNative.AntdNativeFacade.{List => AntdList, Button, _}
import typings.react.ScalableSlinky._
import typings.atAntDashDesignIconsDashReactDashNative.libFillMod.IconFillProps
import typings.atAntDashDesignIconsDashReactDashNative.libOutlineMod.IconOutlineProps
import typings.atAntDashDesignReactDashNative.PartialLocale
import typings.atAntDashDesignReactDashNative.libModalPropsTypeMod.Action
import typings.atBang88ReactDashNativeDashDrawerDashLayout.atBang88ReactDashNativeDashDrawerDashLayoutMod.{
  default,
  DrawerLayout
}
import typings.reactDashRouterDashNative.ReactRouterNativeFacade._

@react object App {

  type Props = Unit

  val component = FunctionalComponent[Props] { _ =>
    var ref: default | Null = new default {}

    val menuTitles         = List("Home", "Antd2", "React Router")
    val menuPaths          = List("/", "/antd", "/react-router")
    val (path, updatePath) = useState(menuPaths.head)
    val menus = menuTitles.indices.map(
      index =>
        ListItem(
          ListItemProps(
            onPress = _ => {
              updatePath(menuPaths(index))
              ref.asInstanceOf[DrawerLayout].closeDrawer()
            }
          )
        )(
          menuTitles(index)
        ).withKey(index.toString)
    )

    Provider(ProviderProps(locale = PartialLocale(locale = "enUS")))(
      Drawer(
        DrawerProps(
          drawerRef = (ref = _),
          sidebar   = ScrollView(WhiteSpace(WhiteSpaceProps(size = antdStrings.xl)), AntdList(ListProps())(menus)).toST
        )
      )(
        NativeRouter(NativeRouterProps())(
          View()(
            AntdList(ListProps(renderHeader = WhiteSpace(WhiteSpaceProps(size = antdStrings.xl)).toST))(
              ListItem(
                ListItemProps(
                  arrow   = antdStrings.horizontal,
                  onPress = _ => ref.asInstanceOf[DrawerLayout].openDrawer()
                )
              )("Open menu")
            )
          ),
          Text(path),
          Route[Unit](exact = true, path              = "/", render = _ => Home(path)),
          Route[Unit](path  = "/antd", render         = _ => Antd(path)),
          Route[Unit](path  = "/react-router", render = _ => ReactRouter(path))
        )
      )
    )
  }
}
