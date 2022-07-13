package com.example.seanote.storage

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [SeaNoteEntity::class],
    version = 1
)
abstract class SeaNoteDataBase : RoomDatabase() {
    abstract val noteDao: SeaNoteDao
}