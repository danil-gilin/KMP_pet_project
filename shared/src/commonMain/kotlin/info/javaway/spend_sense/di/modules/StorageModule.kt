package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.storage.SettingsManager
import org.koin.dsl.module

object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }
}