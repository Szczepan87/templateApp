package com.example.templateapplication

import android.app.Application
import com.example.templateapplication.di.application.ApplicationInjector
import com.example.templateapplication.di.application.DaggerApplicationComponent
import com.example.templateapplication.di.main.MainComponentProvider
import timber.log.Timber

class TemplateApplication : Application(), MainComponentProvider by ApplicationInjector {

    override fun onCreate() {
        super.onCreate()

        initInjector()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initInjector() {
        DaggerApplicationComponent.factory().application(applicationContext).let {
            ApplicationInjector.init(it)
            it.inject(this)
        }
    }
}