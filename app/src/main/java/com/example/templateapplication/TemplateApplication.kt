package com.example.templateapplication

import android.app.Application
import com.example.templateapplication.di.application.ApplicationInjector
import com.example.templateapplication.di.application.DaggerApplicationComponent
import timber.log.Timber

class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initInjector()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initInjector() {
        ApplicationInjector.init(
            DaggerApplicationComponent.factory().application(applicationContext)
        )
    }
}