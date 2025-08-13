package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.models.platform.DeviceInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

object CoreModule {
    val deviceInfo = module {
        single { DeviceInfo() }
        factory { Dispatchers.Default + SupervisorJob() }
    }
}