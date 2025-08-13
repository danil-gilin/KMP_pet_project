package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.data.db.DbAdapters
import info.javaway.spend_sense.data.rep.category.dao.CategoryDao
import info.javaway.spend_sense.data.rep.events.dao.EventDao
import info.javaway.spend_sense.data.storage.SettingsManager
import info.javaway.spend_sense.db.AppDb
import org.koin.dsl.module

object DBModules {
    val db = module {
        single { AppDb(get(), DbAdapters.categoryDbAdapter, DbAdapters.eventDbAdapter) }
    }
    val dao = module {
        single { CategoryDao(get(), get()) }
        single { EventDao(get(), get()) }
    }
}