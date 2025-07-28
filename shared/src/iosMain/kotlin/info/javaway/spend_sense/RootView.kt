package info.javaway.spend_sense

import androidx.compose.ui.window.ComposeUIViewController
import info.javaway.spend_sense.root.RootScreen
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    RootScreen()
}