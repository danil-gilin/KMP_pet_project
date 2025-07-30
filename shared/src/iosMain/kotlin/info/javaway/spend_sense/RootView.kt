package info.javaway.spend_sense

import androidx.compose.ui.window.ComposeUIViewController
import info.javaway.spend_sense.ui.root.RootScreen
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    RootScreen()
}