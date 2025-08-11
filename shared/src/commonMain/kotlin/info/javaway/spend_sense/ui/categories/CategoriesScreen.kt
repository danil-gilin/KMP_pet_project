package info.javaway.spend_sense.ui.categories

import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import info.javaway.spend_sense.common.ui.atoms.FAB
import info.javaway.spend_sense.common.ui.atoms.RootBox
import info.javaway.spend_sense.presenter.categories.CategoriesViewModel
import info.javaway.spend_sense.ui.categories.list.compose.CategoriesListView
import info.javaway.spend_sense.ui.categories.list.compose.CreateCategoryView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(viewModel: CategoriesViewModel) {

    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            CreateCategoryView(
                isExpand = sheetState.currentValue == ModalBottomSheetValue.Expanded,
                createListener = {
                    scope.launch { sheetState.hide() }
                    viewModel.createCategories(it)
                }
            )
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.Transparent,
        modifier = Modifier.zIndex(1f),
    ) {
        RootBox {
            CategoriesListView(
                viewModel = viewModel,
                modifier = Modifier
            ) { category ->
            }

            FAB { scope.launch { sheetState.show() } }
        }
    }
}