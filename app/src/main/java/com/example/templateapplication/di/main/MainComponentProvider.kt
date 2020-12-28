package com.example.templateapplication.di.main

import androidx.appcompat.app.AppCompatActivity

interface MainComponentProvider {

    fun provideMainComponent(activity: AppCompatActivity): MainComponent

    fun clearMainComponent()
}