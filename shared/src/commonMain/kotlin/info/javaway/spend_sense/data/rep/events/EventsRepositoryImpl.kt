package info.javaway.spend_sense.data.rep.events

import info.javaway.spend_sense.presenter.events.model.SpendEvent
import kotlinx.coroutines.flow.flow

class EventsRepositoryImpl : EventsRepository {
    override fun getAllFlow() = flow { emit(SpendEvent.getStubs()) }

    override suspend fun create(spendEvent: SpendEvent) = Unit
}