package com.example.templateapplication.di.main

import androidx.lifecycle.ViewModel
import com.example.core.di.ActivityScope
import com.example.core.di.ViewModelKey
import com.example.navigation.MainNavigator
import com.example.templateapplication.MainViewModel
import com.example.templateapplication.navigators.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @ActivityScope
    fun bindMainInnerNavigator(navigator: MainNavigatorImpl): MainNavigator

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
    // TODO bind MainViewModel
}