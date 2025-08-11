package info.javaway.spend_sense.data.rep.category

import info.javaway.spend_sense.ui.categories.model.Category
import kotlinx.coroutines.flow.flow

class CategoriesRepositoryImpl : CategoriesRepository {

    override fun getAllCategories() = flow {
        emit(
            List(20) { index ->
                Category.Companion.NONE.copy(
                    id = index.toString(),
                    title = "category $index"
                )
            }
        )
    }

    override suspend fun createCategory(category: Category) = Unit
}