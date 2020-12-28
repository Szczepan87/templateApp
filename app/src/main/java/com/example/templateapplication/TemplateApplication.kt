package com.example.templateapplication

import android.app.Application
import com.example.templateapplication.di.application.ApplicationInjector
import com.example.templateapplication.di.application.DaggerApplicationComponent

class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initInjector()
    }

    private fun initInjector() {
        ApplicationInjector.init(
            DaggerApplicationComponent.factory().application(applicationContext)
        )
    }
}