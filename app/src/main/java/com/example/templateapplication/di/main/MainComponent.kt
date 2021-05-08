package com.example.templateapplication.di.main

import androidx.appcompat.app.AppCompatActivity
import com.example.core.di.ActivityScope
import com.example.featuredisplayjoke.di.DisplayJokeComponent
import com.example.featuredisplayjoke.di.DisplayJokeModule
import com.example.templateapplication.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [MainModule::class,
        DisplayJokeModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    fun displayJokeComponent(): DisplayJokeComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: AppCompatActivity): MainComponent
    }
}