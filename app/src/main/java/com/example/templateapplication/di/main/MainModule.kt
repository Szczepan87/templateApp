package com.example.templateapplication.di.main

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.templateapplication.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
    // TODO bind MainViewModel
}