package info.javaway.spend_sense.extensions

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun LocalDateTime.Companion.now() =
    Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

fun LocalDate.Companion.now() =
    LocalDateTime.now().date
