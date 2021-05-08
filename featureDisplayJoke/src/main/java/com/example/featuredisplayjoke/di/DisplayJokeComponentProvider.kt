package com.example.featuredisplayjoke.di

import androidx.fragment.app.Fragment


interface DisplayJokeComponentProvider {

    fun provideDisplayJokeComponent(fragment: Fragment): DisplayJokeComponent
    fun clearDisplayJokeComponent()
}