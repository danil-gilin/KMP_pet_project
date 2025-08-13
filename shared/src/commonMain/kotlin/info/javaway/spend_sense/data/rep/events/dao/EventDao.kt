package info.javaway.spend_sense.data.rep.events.dao

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import info.javaway.spend_sense.data.rep.events.toDb
import info.javaway.spend_sense.data.rep.events.toDomain
import info.javaway.spend_sense.db.AppDb
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext

class EventDao(
    private val db: AppDb,
    private val coroutineContext: CoroutineContext
) {

    private val eventsQueries = db.eventsDbQueries

    fun getAll(): List<SpendEvent> = eventsQueries
        .getAll()
        .executeAsList()
        .map { it.toDomain() }

    fun getAllFLow(): Flow<List<SpendEvent>> =
        eventsQueries
            .getAll()
            .asFlow()
            .mapToList(coroutineContext)
            .map { categories -> categories.map { it.toDomain() } }

    suspend fun insert(event: SpendEvent) = eventsQueries.insert(event.toDb())

    suspend fun insertAll(events: List<SpendEvent>) =
        eventsQueries.transaction {
            events.forEach { eventsQueries.insert(it.toDb()) }
        }

    suspend fun delete(id: String) = eventsQueries.delete(id)
}