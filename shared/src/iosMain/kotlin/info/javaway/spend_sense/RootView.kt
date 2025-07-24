package info.javaway.spend_sense

import SayHelloFromCommon
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController = ComposeUIViewController {
    SayHelloFromCommon()
}