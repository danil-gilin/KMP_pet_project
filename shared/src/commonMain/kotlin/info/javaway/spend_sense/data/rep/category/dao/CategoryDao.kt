package info.javaway.spend_sense.data.rep.category.dao

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import info.javaway.spend_sense.data.rep.category.model.toDb
import info.javaway.spend_sense.data.rep.category.model.toDomain
import info.javaway.spend_sense.db.AppDb
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext

class CategoryDao(
    private val db: AppDb,
    private val coroutineContext: CoroutineContext
) {

    private val categoryQueries = db.categoryDbQueries

    fun getAll(): List<Category> = categoryQueries
        .getAll()
        .executeAsList()
        .map { it.toDomain() }

    fun getAllFLow(): Flow<List<Category>> =
        categoryQueries
            .getAll()
            .asFlow()
            .mapToList(coroutineContext)
            .map { categories -> categories.map { it.toDomain() } }

    suspend fun insert(category: Category) = categoryQueries.insert(category.toDb())

    suspend fun insertAll(categories: List<Category>) =
        categoryQueries.transaction {
            categories.forEach { categoryQueries.insert(it.toDb()) }
        }

    suspend fun delete(id: String) = categoryQueries.delete(id)
}