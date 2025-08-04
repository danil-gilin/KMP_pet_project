package info.javaway.spend_sense.data.storage

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class AppSettings actual constructor() {
    actual val settings: Settings = NSUserDefaultsSettings(
        NSUserDefaults.standardUserDefaults
    )
}