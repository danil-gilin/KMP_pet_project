package info.javaway.spend_sense.ui.events.list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.stringResource
import info.javaway.spend_sense.MR
import info.javaway.spend_sense.common.ui.atoms.ColorLabel
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider
import info.javaway.spend_sense.extensions.fromHex
import info.javaway.spend_sense.ui.events.model.SpendEventUi
import org.jetbrains.compose.resources.stringResource

@Composable
fun SpendEventItem(
    spendEventUi: SpendEventUi
) {

    val categoryColor = spendEventUi.category.colorHex.takeIf {
        it.isNotBlank()
    }?.let {
        Color.fromHex(it, AppThemeProvider.colors.accent)
    } ?: AppThemeProvider.colors.accent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                AppThemeProvider.colors.surface.copy(0.8f),
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            if (spendEventUi.title.isNotBlank()) {
                Text(
                    spendEventUi.title,
                    modifier = Modifier.padding(bottom = 2.dp),
                    fontSize = 20.sp,
                    color = AppThemeProvider.colors.onSurface
                )
            }

            Text(
                spendEventUi.category.title.ifEmpty { stringResource(MR.strings.empty_category) },
                modifier = Modifier.padding(bottom = 2.dp),
                fontSize = 16.sp,
                color = categoryColor
            )

            Text(
                spendEventUi.cost.toString(),
                fontSize = 16.sp,
                color = AppThemeProvider.colors.onSurface
            )
        }

        ColorLabel(categoryColor.toArgb().toHexString())
    }
}