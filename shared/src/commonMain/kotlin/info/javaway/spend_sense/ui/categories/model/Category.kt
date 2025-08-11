package info.javaway.spend_sense.ui.categories.model

import info.javaway.spend_sense.extensions.now
import kotlinx.datetime.LocalDateTime

data class Category(
    val id: String,
    val title: String,
    val description: String,
    val createdAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val colorHex: String
) {

    companion object Companion {
        val NONE = Category(
            id = "NONE_CATEGORY",
            title = "",
            description = "",
            createdAt = LocalDateTime.now(),
            updateAt = LocalDateTime.now(),
            colorHex = ""
        )
    }
}
