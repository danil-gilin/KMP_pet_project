package info.javaway.spend_sense.data.models.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.posix.uname
import platform.posix.utsname
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class, ExperimentalForeignApi::class)
actual class DeviceInfo actual constructor() {
    actual val osName = when (UIDevice.Companion.currentDevice.userInterfaceIdiom) {
        UIUserInterfaceIdiomPad -> "IpadOs"
        UIUserInterfaceIdiomPhone -> "iOS"
        else -> Platform.osFamily.name
    }
    actual val osVersion = UIDevice.Companion.currentDevice.systemVersion
    actual val model = memScoped {
        val systemInfo: utsname = alloc()
        uname(systemInfo.ptr)
        return@memScoped NSString.Companion.stringWithCString(
            systemInfo.machine,
            encoding = NSUTF8StringEncoding
        ) ?: "Unknown model"
    }
    actual val cpu = Platform.cpuArchitecture.name
    actual val screenWidth = CGRectGetWidth(UIScreen.Companion.mainScreen.nativeBounds).toInt()
    actual val screenHeight = CGRectGetHeight(UIScreen.Companion.mainScreen.nativeBounds).toInt()
    actual val screenDestiny = UIScreen.Companion.mainScreen.scale.toInt()

    actual fun getSummary() =
        "osName: $osName\n" +
                "osVersion: $osVersion\n" +
                "model: $model\n" +
                "cpu: $cpu\n" +
                "screenWidth: $screenWidth\n" +
                "screenHeight: $screenHeight\n" +
                "screenDestiny: $screenDestiny\n"

}