package info.javaway.spend_sense.presenter.settings

import info.javaway.spend_sense.common.view_model.BaseViewState

class SettingsContract {

    data class State(
        val info: String,
        val themeDark: Boolean
    ) : BaseViewState {
        companion object {
            val NONE = State(
                info = "",
                themeDark = false
            )
        }
    }
}