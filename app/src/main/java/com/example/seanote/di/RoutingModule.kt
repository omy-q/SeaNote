package com.example.seanote.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoutingModule {
    private val cicerone by lazy { Cicerone.create() }

    @Singleton
    @Provides
    fun getRouter(): Router = cicerone.router

    @Singleton
    @Provides
    fun getNavigator(): NavigatorHolder = cicerone.getNavigatorHolder()
}