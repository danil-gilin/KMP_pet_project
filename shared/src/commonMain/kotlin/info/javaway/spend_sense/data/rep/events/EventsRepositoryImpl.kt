package info.javaway.spend_sense.data.rep.events

import info.javaway.spend_sense.data.rep.events.dao.EventDao
import info.javaway.spend_sense.presenter.events.model.SpendEvent

class EventsRepositoryImpl(
    private val dao: EventDao
) : EventsRepository {
    override fun getAllFlow() = dao.getAllFLow()

    override suspend fun create(spendEvent: SpendEvent)  {
        dao.insert(spendEvent)
    }
}