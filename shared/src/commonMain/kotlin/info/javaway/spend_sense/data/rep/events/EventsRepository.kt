package info.javaway.spend_sense.data.rep.events

import info.javaway.spend_sense.presenter.events.model.SpendEvent
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    fun getAllFlow(): Flow<List<SpendEvent>>
    suspend fun create(spendEvent: SpendEvent)
}