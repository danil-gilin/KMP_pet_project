package info.javaway.spend_sense.di.modules

import info.javaway.spend_sense.common.ui.calendar.DatePickerViewModel
import info.javaway.spend_sense.presenter.categories.CategoriesViewModel
import info.javaway.spend_sense.presenter.settings.SettingsViewModel
import info.javaway.spend_sense.root.RootViewModel
import org.koin.dsl.module

object ViewModelsModule {
    val viewModels = module {
        single { RootViewModel(get()) }
        single { CategoriesViewModel(get()) }
        single { DatePickerViewModel() }
        factory { SettingsViewModel(get(), get()) }
    }
}