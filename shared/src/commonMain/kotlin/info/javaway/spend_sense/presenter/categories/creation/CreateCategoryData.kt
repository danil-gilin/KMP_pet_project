package info.javaway.spend_sense.presenter.categories.creation

import info.javaway.spend_sense.data.models.platform.randomUUID
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.datetime.LocalDateTime

data class CreateCategoryData(
    val title: String,
    val subtitle: String,
    val colorHex: String
)

fun CreateCategoryData.toCategory(dateTime: LocalDateTime) = Category(
    id = randomUUID(),
    title = title,
    description = subtitle,
    colorHex = colorHex,
    createdAt = dateTime,
    updateAt = dateTime
)
