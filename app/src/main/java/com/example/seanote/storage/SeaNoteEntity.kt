package com.example.seanote.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SeaNoteDataBase.tableName)
data class SeaNoteEntity(
    @PrimaryKey
    val idNote: Int,
    val date: String,
    val title: String,
    val text: List<String>,
    val idTextType: Int,
    val idBackground: Int,
    val idFontType: Int,
    val isFavorite: Int,
    val isToDoList: Int
)