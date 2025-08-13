package info.javaway.spend_sense.data.rep.events

import db.events.EventDb
import info.javaway.spend_sense.presenter.events.model.SpendEvent

fun SpendEvent.toDb() = EventDb(
    id = id,
    title = title,
    createdAt = createdAt,
    cost = cost,
    categoryId = categoryId,
    updateAt = updateAt,
    date = date,
    note = note
)

fun EventDb.toDomain() = SpendEvent(
    id = id,
    title = title.orEmpty(),
    createdAt = createdAt,
    cost = cost ?: 0.0,
    categoryId = categoryId,
    updateAt = updateAt,
    date = date,
    note = note.orEmpty()
)