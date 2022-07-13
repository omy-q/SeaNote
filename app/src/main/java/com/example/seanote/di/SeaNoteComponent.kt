package com.example.seanote.di

import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        BaseScopeModule::class,
        ContextModule::class,
        RoutingModule::class,
        StorageModule::class
    ]
)

@Singleton
interface SeaNoteComponent {
}