package info.javaway.spend_sense.presenter.events.creation

import info.javaway.spend_sense.common.view_model.BaseEvent
import info.javaway.spend_sense.common.view_model.BaseViewState
import info.javaway.spend_sense.extensions.now
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.datetime.LocalDate

interface CreateEventContract {

    data class State(
        val title: String,
        val category: Category,
        val date: LocalDate,
        val cost: Double
    ) : BaseViewState {
        companion object Companion {
            val NONE = State(
                title = "",
                category = Category.NONE,
                date = LocalDate.now(),
                cost = 0.0
            )
        }
    }

    sealed interface Event : BaseEvent {
        data class Finish(val spendEvent: SpendEvent) : Event
    }
}