package info.javaway.spend_sense.ui.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import info.javaway.spend_sense.common.ui.AppPrefs
import info.javaway.spend_sense.common.ui.AppTheme
import info.javaway.spend_sense.common.ui.AppThemeProvider
import info.javaway.spend_sense.presenter.settings.SettingsViewModel
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.ui.settings.SettingsScreen

@Composable
fun RootScreen(viewModel: RootViewModel) {
    val state by viewModel.state.collectAsState()
    val viewModel = remember { SettingsViewModel() }

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Scaffold(
            containerColor = AppThemeProvider.colors.background,
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            SettingsScreen(
                viewModel,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}