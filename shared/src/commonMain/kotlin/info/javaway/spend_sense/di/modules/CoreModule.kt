package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.models.platform.DeviceInfo
import org.koin.dsl.module

object CoreModule {
    val deviceInfo = module {
        single { DeviceInfo() }
    }
}