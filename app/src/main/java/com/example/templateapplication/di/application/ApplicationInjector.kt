package com.example.templateapplication.di.application

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.featuredisplayjoke.di.DisplayJokeComponent
import com.example.featuredisplayjoke.di.DisplayJokeComponentProvider
import com.example.templateapplication.di.main.MainComponent
import com.example.templateapplication.di.main.MainComponentProvider

object ApplicationInjector :
    MainComponentProvider,
    DisplayJokeComponentProvider {

    private lateinit var appComponent: ApplicationComponent

    private var mainComponent: MainComponent? = null
    private var displayJokeComponent: DisplayJokeComponent? = null

    fun init(appComponent: ApplicationComponent) {
        ApplicationInjector.appComponent = appComponent
    }

    override fun provideMainComponent(activity: AppCompatActivity): MainComponent {
        return appComponent.mainComponent().create(activity).also { mainComponent = it }
    }

    override fun clearMainComponent() {
        mainComponent = null
    }

    override fun provideDisplayJokeComponent(fragment: Fragment): DisplayJokeComponent {
        return displayJokeComponent ?: mainComponent?.displayJokeComponent()?.create(fragment)
            .also {
                displayJokeComponent = it
            } ?: throw IllegalStateException()
    }

    override fun clearDisplayJokeComponent() {
        displayJokeComponent = null
    }
}