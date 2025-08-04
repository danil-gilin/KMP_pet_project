package info.javaway.spend_sense.root

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.storage.SettingsManager
import info.javaway.spend_sense.root.model.AppTab
import info.javaway.spend_sense.root.model.RootContract
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RootViewModel(
    private val settingsManager: SettingsManager
) : BaseViewModel<RootContract.State, Nothing>(){
    override fun initialState() = RootContract.State()

    init {
        settingsManager.themeIsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    fun handleOnTabClicked(appTab: AppTab) {
        updateState { copy(selectedTab = appTab) }
    }
}