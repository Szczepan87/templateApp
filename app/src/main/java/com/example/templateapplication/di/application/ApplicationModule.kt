package com.example.templateapplication.di.application

import com.example.domain.di.MoshiTypeAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideMoshi(
        jsonAdapters: MutableMap<Class<out Any>,
                @JvmSuppressWildcards Provider<JsonAdapter<out Any>>>,
        @MoshiTypeAdapter adapters: Set<@JvmSuppressWildcards Any>
    ): Moshi {
        return Moshi.Builder()
            .apply {
                jsonAdapters.forEach { (type, provider) ->
                    add(type, provider.get())
                }

                adapters.forEach { adapter ->
                    add(adapter)
                }
            }.build()
    }
}