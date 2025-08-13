package info.javaway.spend_sense.data.rep.category.model

import db.categories.CategoryDb
import info.javaway.spend_sense.ui.categories.model.Category

fun CategoryDb.toDomain() = Category(
    id = id,
    title = title.orEmpty(),
    description = description.orEmpty(),
    createdAt = createdAt,
    updateAt = updateAt,
    colorHex = colorHex
)

fun Category.toDb() = CategoryDb(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    updateAt = updateAt,
    colorHex = colorHex
)
