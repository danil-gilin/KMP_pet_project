package info.javaway.spend_sense.ui.root.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import info.javaway.spend_sense.common.ui.AppThemeProvider
import info.javaway.spend_sense.root.model.AppTab
import info.javaway.spend_sense.root.model.BottomBarItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BoxScope.RootBottomBar(
    selectedItem: AppTab,
    clickOnTab: (AppTab) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                AppThemeProvider.colors.surface,
                shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)
            )
            .padding(8.dp)
            .align(Alignment.BottomCenter)
    ) {
        BottomBarItem.getItems().forEach { item ->
            key(item.appTan) {
                BottomBarItemView(
                    item,
                    item.appTan == selectedItem,
                    clickOnTab
                )
            }
        }
    }
}

@Composable
fun RowScope.BottomBarItemView(
    bottomBarItem: BottomBarItem,
    isSelected: Boolean,
    clickOnTab: (AppTab) -> Unit
) {

    val foreground =
        if (isSelected) AppThemeProvider.colors.accent else AppThemeProvider.colors.onSurface
    Column(
        modifier = Modifier.weight(1f).padding(4.dp).clickable {
            clickOnTab(bottomBarItem.appTan)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(bottomBarItem.icon),
            contentDescription = stringResource(bottomBarItem.title),
            modifier = Modifier.size(22.dp).padding(bottom = 4.dp),
            colorFilter = ColorFilter.tint(foreground)
        )
        Text(
            text = stringResource(bottomBarItem.title),
            color = foreground
        )
    }
}