package com.example.seanote.storage

import androidx.room.*
import com.example.seanote.storage.SeaNoteDataBase.Companion.tableName

@Dao
interface SeaNoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: SeaNoteEntity)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateNote(note: SeaNoteEntity)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateNotes(notes: List<SeaNoteEntity>)

    @Delete
    fun deleteNote(note: SeaNoteEntity)

    @Delete
    fun deleteNote(notes: List<SeaNoteEntity>)

    @Query("SELECT * FROM $tableName ORDER BY date")
    fun getAllNotes(): List<SeaNoteEntity>

    @Query("SELECT * FROM $tableName WHERE isFavorite = 1 ORDER BY date")
    fun getFavoriteNotes(): List<SeaNoteEntity>
}