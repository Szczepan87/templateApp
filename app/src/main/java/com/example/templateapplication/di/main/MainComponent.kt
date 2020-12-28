package com.example.templateapplication.di.main

import androidx.appcompat.app.AppCompatActivity
import com.example.core.di.ActivityScope
import com.example.templateapplication.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: AppCompatActivity): MainComponent
    }
}