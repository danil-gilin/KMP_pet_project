package info.javaway.spend_sense.ui.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import info.javaway.spend_sense.presenter.settings.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel
) {

    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Column {
            Text(text = state.deviceInfo)

            Row( verticalAlignment = Alignment.CenterVertically,){
                Text(
                    "Dark theme",
                    modifier = Modifier
                        .weight(1f)
                )
                Checkbox(
                    state.themeDark,
                    onCheckedChange = { viewModel.switchTheme(it) }
                )
            }
        }
    }
}