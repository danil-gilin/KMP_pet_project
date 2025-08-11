package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.rep.category.CategoriesRepository
import info.javaway.spend_sense.data.rep.category.CategoriesRepositoryImpl
import info.javaway.spend_sense.data.storage.SettingsManager
import org.koin.dsl.bind
import org.koin.dsl.module

object RepositoryModule {
    val repository = module {
        single { CategoriesRepositoryImpl() } bind CategoriesRepository::class
    }
}