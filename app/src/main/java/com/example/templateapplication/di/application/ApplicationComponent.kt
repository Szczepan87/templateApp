package com.example.templateapplication.di.application

import android.content.Context
import com.example.api.di.ApiModule
import com.example.core.di.CoreModule
import com.example.data.di.DataModule
import com.example.domain.di.DomainModule
import com.example.templateapplication.TemplateApplication
import com.example.templateapplication.di.main.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ApplicationModule::class,
        CoreModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface ApplicationComponent {
    fun inject(app: TemplateApplication)

    fun mainComponent(): MainComponent.Factory

    @Component.Factory
    interface Factory {
        fun application(@BindsInstance context: Context): ApplicationComponent
    }
}