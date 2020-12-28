package com.example.core.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
class CoroutinesModule {

    @Provides
    @Named("default")
    fun getDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Named("io")
    fun getIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Named("main")
    fun getMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}