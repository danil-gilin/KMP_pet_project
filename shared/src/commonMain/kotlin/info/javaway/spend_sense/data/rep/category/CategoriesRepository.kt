package info.javaway.spend_sense.data.rep.category

import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun createCategory(category: Category)
}