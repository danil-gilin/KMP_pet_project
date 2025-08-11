package info.javaway.spend_sense.data.models.platform

import platform.Foundation.NSUUID

actual fun randomUUID() : String = NSUUID().UUIDString