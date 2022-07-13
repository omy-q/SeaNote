package com.example.seanote.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val appContext: Application) {

    @Singleton
    @Provides
    fun appContext(): Context = appContext
}