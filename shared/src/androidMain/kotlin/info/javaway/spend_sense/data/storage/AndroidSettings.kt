package info.javaway.spend_sense.data.storage

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import info.javaway.spend_sense.App

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class AppSettings actual constructor() {
    actual val settings: Settings = SharedPreferencesSettings(
        App.instance.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
    )
}