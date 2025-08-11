package info.javaway.spend_sense.presenter.categories

import info.javaway.spend_sense.common.view_model.BaseViewState
import info.javaway.spend_sense.ui.categories.model.Category

class CategoriesContract {

    data class State(
        val categories: List<Category>
    ) : BaseViewState {
        companion object {
            val NONE = State(
                categories = emptyList()
            )
        }
    }
}