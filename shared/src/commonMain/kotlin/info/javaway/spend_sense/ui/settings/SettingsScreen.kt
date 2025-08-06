package info.javaway.spend_sense.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import info.javaway.spend_sense.MR
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider
import info.javaway.spend_sense.presenter.settings.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Column {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                backgroundColor = AppThemeProvider.colors.surface,
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = state.info,
                    color = AppThemeProvider.colors.onSurface
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .background(AppThemeProvider.colors.surface, RoundedCornerShape(16.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = stringResource( MR.strings.dark_theme),
                    color = AppThemeProvider.colors.onSurface
                )
                Checkbox(
                    state.themeDark,
                    onCheckedChange = { viewModel.switchTheme(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppThemeProvider.colors.accent,
                        uncheckedColor = AppThemeProvider.colors.onSurface
                    )
                )
            }
        }
    }
}