package com.example.featuredisplayjoke.di

import androidx.fragment.app.Fragment
import com.example.featuredisplayjoke.DisplayJokeFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [DisplayJokeModule::class])
interface DisplayJokeComponent {

    fun inject(fragment: DisplayJokeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): DisplayJokeComponent
    }
}