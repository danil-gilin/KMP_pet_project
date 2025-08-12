package info.javaway.spend_sense.presenter.events

import info.javaway.spend_sense.common.ui.calendar.extensions.initValue
import info.javaway.spend_sense.common.ui.calendar.model.CalendarDay
import info.javaway.spend_sense.common.ui.calendar.model.CalendarLabel
import info.javaway.spend_sense.common.view_model.BaseViewState
import info.javaway.spend_sense.extensions.now
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import info.javaway.spend_sense.presenter.events.model.toUi
import info.javaway.spend_sense.ui.categories.model.Category
import info.javaway.spend_sense.ui.events.model.SpendEventUi
import kotlinx.datetime.LocalDate

class EventsContract {

    data class State(
        val selectedDay: CalendarDay?,
        val events: List<SpendEvent>,
        val categories: List<Category>,
        val calendarLabels: List<CalendarLabel>
    ) : BaseViewState {
        val eventsByDay: List<SpendEventUi>
            get() = events.filter { it.date == selectedDay?.date }
                .map { spendEvent ->
                    spendEvent.toUi(
                        categories.firstOrNull { it.id == spendEvent.categoryId } ?: Category.NONE
                    )
                }

        companion object Companion {
            val NONE = State(
                selectedDay = null,
                events = emptyList(),
                categories = emptyList(),
                calendarLabels = emptyList()
            )
        }
    }
}