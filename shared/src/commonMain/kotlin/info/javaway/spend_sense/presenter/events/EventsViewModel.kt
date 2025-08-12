package info.javaway.spend_sense.presenter.events

import info.javaway.spend_sense.common.ui.calendar.model.CalendarDay
import info.javaway.spend_sense.common.ui.calendar.model.CalendarLabel
import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.rep.category.CategoriesRepository
import info.javaway.spend_sense.data.rep.events.EventsRepository
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import info.javaway.spend_sense.presenter.events.model.toCalendarLabel
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class EventsViewModel(
    private val categoriesRepository: CategoriesRepository,
    private val eventsRepository: EventsRepository
): BaseViewModel<EventsContract.State, Nothing>() {
    override fun initialState(): EventsContract.State = EventsContract.State.NONE

    init {
        subscribeData()
    }

    fun selectDay(day: CalendarDay) = updateState { copy(selectedDay = day) }

    fun createEvent(newEvent: SpendEvent) {
        viewModelScope.launch {
            eventsRepository.create(newEvent)
        }
    }

    private fun subscribeData() {
        combine(
            categoriesRepository.getAllCategories(),
            eventsRepository.getAllFlow()
        ) { categories, events ->
            val labels = mapEventsCategoriesToLabels(events, categories)
            updateState {
                copy(
                    events = events,
                    categories = categories,
                    calendarLabels = labels
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun mapEventsCategoriesToLabels(
        events: List<SpendEvent>,
        categories: List<Category>
    ): List<CalendarLabel> {
        return events.map { event ->
            val category = categories.firstOrNull {
                it.id == event.categoryId
            } ?: Category.NONE
            event.toCalendarLabel(category)
        }
    }
}