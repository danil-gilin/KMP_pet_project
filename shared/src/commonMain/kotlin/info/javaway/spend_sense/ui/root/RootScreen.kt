package info.javaway.spend_sense.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import info.javaway.spend_sense.categories.CategoriesScreen
import info.javaway.spend_sense.common.ui.AppTheme
import info.javaway.spend_sense.common.ui.AppThemeProvider
import info.javaway.spend_sense.events.EventsScreen
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.root.model.AppTab
import info.javaway.spend_sense.ui.root.functions.RootBottomBar
import info.javaway.spend_sense.ui.settings.SettingsScreen

@Composable
fun RootScreen(viewModel: RootViewModel) {
    val state by viewModel.state.collectAsState()

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Scaffold(
            containerColor = AppThemeProvider.colors.background,
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {

                RootNavigation(state.selectedTab)
                RootBottomBar(state.selectedTab) { tab ->
                    viewModel.handleOnTabClicked(tab)
                }
            }
        }
    }
}


@Composable
fun BoxScope.RootNavigation(selectedTab: AppTab) {

    when (selectedTab) {
        AppTab.Events -> EventsScreen(modifier = Modifier.align(Alignment.Center))
        AppTab.Settings -> SettingsScreen(modifier = Modifier.align(Alignment.Center))
        AppTab.Categories -> CategoriesScreen(modifier = Modifier.align(Alignment.Center))
    }
}