package info.javaway.spend_sense.di

import info.javaway.spend_sense.di.modules.CoreModule
import info.javaway.spend_sense.di.modules.DBModules
import info.javaway.spend_sense.di.modules.RepositoryModule
import info.javaway.spend_sense.di.modules.StorageModule
import info.javaway.spend_sense.di.modules.ViewModelsModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

expect val platformModule: Module

inline fun <reified T> getKoinInstance(qualifier: Qualifier? = null): T {
    return object : KoinComponent {
        val value: T by inject(qualifier)
    }.value
}

fun initKoin(
    appModule: Module = module {  }
) = startKoin {
    modules(
        CoreModule.deviceInfo,
        StorageModule.settings,
        ViewModelsModule.viewModels,
        RepositoryModule.repository,
        platformModule,
        appModule,
        DBModules.dao,
        DBModules.db
    )
}