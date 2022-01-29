package com.example.templateapplication.di.application

import androidx.appcompat.app.AppCompatActivity
import com.example.templateapplication.di.main.MainComponent
import com.example.templateapplication.di.main.MainComponentProvider

object ApplicationInjector : MainComponentProvider {

    private lateinit var appComponent: ApplicationComponent

    private var mainComponent: MainComponent? = null

    fun init(appComponent: ApplicationComponent) {
        this.appComponent = appComponent
    }

    override fun provideMainComponent(activity: AppCompatActivity): MainComponent {
        return appComponent.mainComponent().create(activity).also { mainComponent = it }
    }

    override fun clearMainComponent() {
        mainComponent = null
    }
}