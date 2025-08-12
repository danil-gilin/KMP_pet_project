package info.javaway.spend_sense.di.qualifier

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.ext.getFullName

object DataPickerSingleQualifier : Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}


object DataPickerFactoryQualifier : Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}