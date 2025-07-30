package info.javaway.spend_sense.data.models.platform

import android.content.res.Resources
import android.os.Build
import kotlin.math.roundToInt

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DeviceInfo actual constructor() {
    private val displayMetrics = Resources.getSystem().displayMetrics

    actual val osName: String = "Android"
    actual val osVersion: String = "${Build.VERSION.SDK_INT}"
    actual val model: String = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpu: String = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown cpu"
    actual val screenWidth: Int = displayMetrics.widthPixels
    actual val screenHeight: Int = displayMetrics.heightPixels
    actual val screenDestiny: Int = displayMetrics.density.roundToInt()

    actual fun getSummary() =
        "osName: $osName\n" +
                "osVersion: $osVersion\n" +
                "model: $model\n" +
                "cpu: $cpu\n" +
                "screenWidth: $screenWidth\n" +
                "screenHeight: $screenHeight\n" +
                "screenDestiny: $screenDestiny\n"
}