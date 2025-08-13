package info.javaway.spend_sense.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import info.javaway.spend_sense.db.AppDb
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import java.util.prefs.Preferences

actual val platformModule: Module = module {
    single { PreferencesSettings(Preferences.userRoot()) } bind Settings::class
    single<SqlDriver> {
      //  val driver = JdbcSqliteDriver("jdbc:sqlite:AppDb.db") надо проверять была ли инициализирована база данных
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        AppDb.Schema.create(driver = driver)
        driver
    }
}