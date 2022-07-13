package com.example.seanote.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeaNoteEntity(
    @PrimaryKey val id: Int
)