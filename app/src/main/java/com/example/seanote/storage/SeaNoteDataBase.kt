package com.example.seanote.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [SeaNoteEntity::class], version = 1)
@TypeConverters(NoteTextConverter::class)
abstract class SeaNoteDataBase : RoomDatabase() {
    abstract val noteDao: SeaNoteDao

    companion object {
        const val tableName = "SeaNoteEntity"
    }
}