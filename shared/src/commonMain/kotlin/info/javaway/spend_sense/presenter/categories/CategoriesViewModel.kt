package info.javaway.spend_sense.presenter.categories

import info.javaway.spend_sense.common.view_model.BaseViewModel
import info.javaway.spend_sense.data.rep.category.CategoriesRepository
import info.javaway.spend_sense.extensions.now
import info.javaway.spend_sense.presenter.categories.creation.CreateCategoryData
import info.javaway.spend_sense.presenter.categories.creation.toCategory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : BaseViewModel<CategoriesContract.State, Nothing>() {

    init {
        subscribeCategories()
    }

    fun createCategories(
        createCategoryData: CreateCategoryData
    ) {
        viewModelScope.launch {
            repository.createCategory(createCategoryData.toCategory(LocalDateTime.now()))
        }
    }

    private fun subscribeCategories() {
        repository.getAllCategories().onEach {
            updateState { copy(categories = it) }
        }.launchIn(viewModelScope)
    }

    override fun initialState(): CategoriesContract.State = CategoriesContract.State.NONE
}