package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.rep.category.CategoriesRepository
import info.javaway.spend_sense.data.rep.category.CategoriesRepositoryImpl
import info.javaway.spend_sense.data.rep.events.EventsRepository
import info.javaway.spend_sense.data.rep.events.EventsRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

object RepositoryModule {
    val repository = module {
        single { CategoriesRepositoryImpl(get()) } bind CategoriesRepository::class
        single { EventsRepositoryImpl(get()) } bind EventsRepository::class
    }
}