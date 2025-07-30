package info.javaway.spend_sense.presenter.settings

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.storage.SettingsManager
import info.javaway.spend_sense.data.models.platform.DeviceInfo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SettingsViewModel : BaseViewModel<SettingsContract.State, Nothing>() {

    init {

        SettingsManager.themeIsDarkFlow.onEach {
            updateState {
                copy(themeDark = it)
            }
        }.launchIn(viewModelScope)

        val deviceInfo = DeviceInfo()
        updateState {
            copy(deviceInfo = deviceInfo.getSummary())
        }
    }

    fun switchTheme(isDark: Boolean) {
        SettingsManager.themeIsDark = isDark
    }

    override fun initialState() = SettingsContract.State.NONE
}