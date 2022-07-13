package com.example.seanote.di

import android.content.Context
import androidx.room.Room
import com.example.seanote.storage.SeaNoteDataBase
import com.example.seanote.storage.StorageModel
import com.example.seanote.storage.StorageModelImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun db(context: Context): SeaNoteDataBase =
        Room
            .databaseBuilder(context, SeaNoteDataBase::class.java, DB_NAME)
            .build()


    @Singleton
    @Provides
    fun storageModel(db: SeaNoteDataBase): StorageModel = StorageModelImpl(db)

    companion object {
        private const val DB_NAME = "seaNoteDatabase.db"
    }
}