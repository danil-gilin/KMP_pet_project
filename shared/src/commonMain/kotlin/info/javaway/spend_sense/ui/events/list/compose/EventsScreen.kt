package info.javaway.spend_sense.ui.events.list.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import info.javaway.spend_sense.common.ui.atoms.FAB
import info.javaway.spend_sense.common.ui.atoms.RootBox
import info.javaway.spend_sense.common.ui.calendar.compose.CalendarColors
import info.javaway.spend_sense.common.ui.calendar.compose.DatePickerView
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider
import info.javaway.spend_sense.di.getKoinInstance
import info.javaway.spend_sense.di.qualifier.DataPickerSingleQualifier
import info.javaway.spend_sense.presenter.events.EventsViewModel
import info.javaway.spend_sense.ui.events.creation.compose.CreateEventView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(eventsViewModel: EventsViewModel) {

    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()
    val state by eventsViewModel.state.collectAsState()

    ModalBottomSheetLayout(
        sheetContent = {
            CreateEventView(
                isExpand = sheetState.currentValue == ModalBottomSheetValue.Expanded,
                selectedDate = state.selectedDay,
                viewModel = getKoinInstance(),
                createListener = { event ->
                    eventsViewModel.createEvent(event)
                    scope.launch { sheetState.hide() }
                }
            )
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.Transparent,
        modifier = Modifier.zIndex(1f),
    ) {
        RootBox {
            Column {
                DatePickerView(
                    viewModel = getKoinInstance(DataPickerSingleQualifier),
                    colors = CalendarColors.default.copy(
                        colorSurface = AppThemeProvider.colors.surface,
                        colorOnSurface = AppThemeProvider.colors.onSurface,
                        colorAccent = AppThemeProvider.colors.accent
                    ),
                    firstDayIsMonday = AppThemeProvider.appPrefs.firstDayIsMonday,
                    labels = state.calendarLabels,
                    selectDayListener = eventsViewModel::selectDay
                )

                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(state.eventsByDay, key = { it.id }) { eventUi ->
                        SpendEventItem(eventUi)
                    }
                }
            }

            FAB{scope.launch { sheetState.show() }}
        }
    }
}