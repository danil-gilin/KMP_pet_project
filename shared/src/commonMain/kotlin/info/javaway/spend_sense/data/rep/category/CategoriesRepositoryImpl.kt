package info.javaway.spend_sense.data.rep.category

import info.javaway.spend_sense.data.rep.category.dao.CategoryDao
import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.coroutines.flow.flow

class CategoriesRepositoryImpl(
    private val dao: CategoryDao
) : CategoriesRepository {

    override fun getAllCategories() = dao.getAllFLow()

    override suspend fun createCategory(category: Category) {
        dao.insert(category)
    }
}