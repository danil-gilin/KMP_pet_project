package info.javaway.spend_sense.root.model

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import info.javaway.spend_sense.MR

data class BottomBarItem(

    val title: StringResource,
    val appTan: AppTab,
    val icon: ImageResource
) {
    companion object {
        fun getItems() = listOf(
            BottomBarItem(MR.strings.events, AppTab.Events, MR.images.ic_event),
            BottomBarItem(MR.strings.categories, AppTab.Categories, MR.images.ic_category),
            BottomBarItem(MR.strings.settings, AppTab.Settings, MR.images.ic_settings),
        )
    }
}
