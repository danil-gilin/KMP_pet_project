package info.javaway.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 * Упрощенная копия [androidx.compose.material3.Scaffold],
 */
@Composable
fun ScaffoldBase(
    modifier: Modifier = Modifier,
    topBar: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val navBarPaddingTop = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    Layout(
        modifier = modifier,
        content = {
            topBar?.let { it() }
            content()
        }
    ) { measurables, constraints ->
        if (topBar == null) {
            val contentMeasurable = measurables[0]
            val contentMaxHeight = constraints.maxHeight
            val contentPlaceable = contentMeasurable.measure(constraints.copy(minHeight = 0, maxHeight = contentMaxHeight))

            layout(constraints.maxWidth, constraints.maxHeight) {
                contentPlaceable.placeRelative(0, navBarPaddingTop.value.toInt())
            }
        } else {
            val topBarMeasurable = measurables[0]
            val topBarPlaceable = topBarMeasurable.measure(constraints.copy(minHeight = 0, maxHeight = Int.MAX_VALUE))

            val contentMeasurable = measurables[1]
            val contentMaxHeight = constraints.maxHeight - topBarPlaceable.height
            val contentPlaceable = contentMeasurable.measure(constraints.copy(minHeight = 0, maxHeight = contentMaxHeight))

            layout(constraints.maxWidth, constraints.maxHeight) {
                topBarPlaceable.placeRelative(0, 0)
                contentPlaceable.placeRelative(0, topBarPlaceable.height)
            }
        }
    }
}