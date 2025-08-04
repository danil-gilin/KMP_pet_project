package info.javaway.spend_sense.presenter.settings

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.storage.SettingsManager
import info.javaway.spend_sense.data.models.platform.DeviceInfo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SettingsViewModel(
    private val deviceInfo: DeviceInfo,
    private val settingsManager: SettingsManager
) : BaseViewModel<SettingsContract.State, Nothing>() {

    init {

        settingsManager.themeIsDarkFlow.onEach {
            updateState {
                copy(themeDark = it)
            }
        }.launchIn(viewModelScope)

        updateState {
            copy(info = deviceInfo.getSummary())
        }
    }

    fun switchTheme(isDark: Boolean) {
        settingsManager.themeIsDark = isDark
    }

    override fun initialState() = SettingsContract.State.NONE
}