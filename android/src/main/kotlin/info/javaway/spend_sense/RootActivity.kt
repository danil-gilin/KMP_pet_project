package info.javaway.spend_sense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import info.javaway.component.ScaffoldBase
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.ui.root.RootScreen

class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen(RootViewModel())
        }
    }
}