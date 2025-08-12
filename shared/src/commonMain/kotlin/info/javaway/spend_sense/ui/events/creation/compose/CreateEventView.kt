package info.javaway.spend_sense.ui.events.creation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import dev.icerock.moko.resources.compose.stringResource
import info.javaway.spend_sense.MR
import info.javaway.spend_sense.common.ui.atoms.AppButton
import info.javaway.spend_sense.common.ui.atoms.AppTextField
import info.javaway.spend_sense.common.ui.atoms.BottomModalContainer
import info.javaway.spend_sense.common.ui.atoms.TextPairButton
import info.javaway.spend_sense.common.ui.calendar.compose.CalendarColors
import info.javaway.spend_sense.common.ui.calendar.compose.DatePickerView
import info.javaway.spend_sense.common.ui.calendar.model.CalendarDay
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider
import info.javaway.spend_sense.di.getKoinInstance
import info.javaway.spend_sense.di.qualifier.DataPickerFactoryQualifier
import info.javaway.spend_sense.presenter.events.creation.CreateEventContract
import info.javaway.spend_sense.presenter.events.creation.CreateEventViewModel
import info.javaway.spend_sense.presenter.events.model.SpendEvent
import info.javaway.spend_sense.ui.categories.list.compose.CategoriesListView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun CreateEventView(
    isExpand: Boolean,
    selectedDate: CalendarDay?,
    viewModel: CreateEventViewModel,
    createListener: (SpendEvent) -> Unit
) {

    val state by viewModel.state.collectAsState()
    var showDateDialog by remember { mutableStateOf(false) }
    var showCategoriesDialog by remember { mutableStateOf(false) }

    LaunchedEffect(isExpand) {
        if (isExpand) {
            viewModel.selectDate(selectedDate?.date)
        } else {
            viewModel.resetState()
        }

        viewModel.events.onEach { event ->
            when (event) {
                is CreateEventContract.Event.Finish -> createListener(event.spendEvent)
            }
        }.launchIn(this)
    }


    BottomModalContainer {
        TextPairButton(
            title = stringResource(MR.strings.category),
            buttonTitle = state.category.title.ifEmpty { stringResource(MR.strings.empty_category) },
            colorHex = state.category.colorHex.takeIf { it.isNotEmpty() },
            onClick = {
                showCategoriesDialog = true
            }
        )

        TextPairButton(
            title = stringResource(MR.strings.date),
            buttonTitle = state.date.toString(),
            onClick = {
                showDateDialog = true
            }
        )

        AppTextField(
            state.title,
            placeholder = stringResource(MR.strings.spend_to),
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                viewModel.changeTitle(it)
            }
        )


        AppTextField(
            state.cost.toString(),
            placeholder = stringResource(MR.strings.cost),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                viewModel.changeCost(it)
            }
        )

        AppButton(
            stringResource(MR.strings.save),
            omClick = {
                viewModel.finish()
            }
        )
    }

    if (showCategoriesDialog) {
        Dialog(
            onDismissRequest = { showCategoriesDialog = false }
        ) {
            CategoriesListView(
                modifier = Modifier.background(
                    AppThemeProvider.colors.surface,
                    RoundedCornerShape(16.dp)
                ),
                onClick = {
                    viewModel.selectCategory(it)
                    showCategoriesDialog = false
                },
                viewModel = getKoinInstance()
            )
        }
    }

    if (showDateDialog) {
        Dialog(
            onDismissRequest = { showDateDialog = false }
        ) {
            DatePickerView(
                getKoinInstance(DataPickerFactoryQualifier),
                colors = CalendarColors.default.copy(
                    colorAccent = AppThemeProvider.colors.accent,
                    colorSurface = AppThemeProvider.colors.surface,
                    colorOnSurface = AppThemeProvider.colors.onSurface
                ),
                selectDayListener = {
                    viewModel.selectDate(it.date)
                    showDateDialog = false
                }
            )
        }
    }
}