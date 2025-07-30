package info.javaway.spend_sense.ui.root

import androidx.compose.runtime.Composable
import info.javaway.spend_sense.presenter.settings.SettingsViewModel
import info.javaway.spend_sense.ui.settings.SettingsScreen

@Composable
fun RootScreen() {
    SettingsScreen(SettingsViewModel())
}