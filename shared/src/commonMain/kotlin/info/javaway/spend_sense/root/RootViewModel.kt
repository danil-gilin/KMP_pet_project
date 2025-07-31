package info.javaway.spend_sense.root

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.storage.SettingsManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RootViewModel : BaseViewModel<RootContract.State, Nothing>(){
    override fun initialState() = RootContract.State()

    init {
        SettingsManager.themeIsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }
}