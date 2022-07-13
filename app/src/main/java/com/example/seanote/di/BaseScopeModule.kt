package com.example.seanote.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton

@Module
class BaseScopeModule {

    @Singleton
    @Provides
    fun mainScope(): CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    @Singleton
    @Provides
    fun ioScope(): CoroutineScope = CoroutineScope(Dispatchers.IO)
}