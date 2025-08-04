package info.javaway.spend_sense.data.storage

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class AppSettings actual constructor() {
    actual val settings: Settings = PreferencesSettings(Preferences.userRoot())
}