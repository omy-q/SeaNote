package com.example.seanote

import android.app.Application
import com.example.seanote.di.ContextModule
import com.example.seanote.di.DaggerSeaNoteComponent
import com.example.seanote.di.SeaNoteComponent

class SeaNoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerSeaNoteComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    companion object {
        private var component: SeaNoteComponent? = null
        fun requireComponent(): SeaNoteComponent {
            return component ?: throw IllegalStateException("Dependencies component not exist")
        }
    }
}