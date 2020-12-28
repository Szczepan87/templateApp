package com.example.domain.di

import dagger.Module

@Module(includes = [DomainAdaptersModule::class])
interface DomainModule