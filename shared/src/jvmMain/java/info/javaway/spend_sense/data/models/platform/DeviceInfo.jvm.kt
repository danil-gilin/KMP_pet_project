package info.javaway.spend_sense.data.models.platform

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DeviceInfo actual constructor() {
    actual val osName = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion = System.getProperty("os.version") ?: "Unknown version"
    actual val model = "Desktop"
    actual val cpu = System.getProperty("os.arch") ?: "Unknown arch"
    actual val screenWidth: Int = 0
    actual val screenHeight: Int = 0
    actual val screenDestiny: Int = 0

    actual fun getSummary(): String {
        return "osName: $osName\n" +
                "osVersion: $osVersion\n" +
                "model: $model\n" +
                "cpu: $cpu\n" +
                "screenWidth: $screenWidth\n" +
                "screenHeight: $screenHeight\n" +
                "screenDestiny: $screenDestiny\n"
    }
}