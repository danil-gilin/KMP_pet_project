package info.javaway.spend_sense.presenter.settings

import info.javaway.spend_sense.common.view_model.BaseViewState
import info.javaway.spend_sense.ui.info.DeviceInfoScreen

class SettingsContract {

    data class State(
        val deviceInfo: String,
        val themeDark: Boolean
    ) : BaseViewState {
        companion object {
            val NONE = State(
                deviceInfo = "",
                themeDark = false
            )
        }
    }
}