package info.javaway.spend_sense.root.model

import info.javaway.spend_sense.common.ui.theme.AppPrefs
import info.javaway.spend_sense.common.view_model.BaseViewState

class RootContract {

    data class State(
        val themeIsDark: Boolean = true,
        val firstDayIsMonday: Boolean = true,
        val selectedTab: AppTab = AppTab.Events
    ) : BaseViewState {
        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)
    }
}