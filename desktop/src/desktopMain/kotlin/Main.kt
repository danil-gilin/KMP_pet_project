import androidx.compose.runtime.remember
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.ui.root.RootScreen

fun main() {

    application {

        val state = rememberWindowState().apply {
            size = DpSize(600.dp, 600.dp)
        }
        Window(
            onCloseRequest = {exitApplication()},
            state = state,
            title = "SpendSense"
        ) {
            val viewModel = remember { RootViewModel() }
            RootScreen(viewModel)
        }
    }
}