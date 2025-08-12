package info.javaway.spend_sense.ui.events.model

import info.javaway.spend_sense.ui.categories.model.Category

data class SpendEventUi(
    val id: String,
    val category: Category,
    val title: String,
    val cost: Double
)
