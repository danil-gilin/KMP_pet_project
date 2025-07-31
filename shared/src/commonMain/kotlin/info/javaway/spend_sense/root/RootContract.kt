package info.javaway.spend_sense.root

import info.javaway.spend_sense.common.ui.AppPrefs
import info.javaway.spend_sense.common.view_model.BaseViewState

class RootContract {

    data class State(
        val themeIsDark: Boolean = true,
        val firstDayIsMonday: Boolean = true
    ) : BaseViewState {
        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)
    }
}