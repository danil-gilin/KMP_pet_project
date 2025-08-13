package info.javaway.spend_sense.presenter.events.creation

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.models.platform.randomUUID
import info.javaway.spend_sense.extensions.now
import info.javaway.spend_sense.presenter.events.creation.CreateEventContract.Event
import info.javaway.spend_sense.presenter.events.creation.CreateEventContract.State
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class CreateEventViewModel : BaseViewModel<State, Event>() {

    fun selectDate(date: LocalDate?) = updateState { copy(date = date ?: LocalDate.now()) }
    fun resetState() = updateState { State.NONE }
    fun changeTitle(title: String) = updateState { copy(title = title) }
    fun changeNote(note: String) = updateState { copy(note = note) }
    fun changeCost(cost: String) = updateState { copy(cost = cost.toDoubleOrNull() ?: this.cost) }
    fun selectCategory(category: Category) = updateState { copy(category = category) }

    fun finish() {
        val now = LocalDateTime.now()
        val spendEvent = with(state.value) {
            SpendEvent(
                id = randomUUID(),
                title = title,
                cost = cost,
                date = date,
                categoryId = category.id,
                createdAt = now,
                updateAt = now,
                note = note
            )
        }
        resetState()
        pushEvent(Event.Finish(spendEvent))
    }

    override fun initialState(): State = State.NONE
}