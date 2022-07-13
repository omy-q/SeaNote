package com.example.seanote.storage

import androidx.room.TypeConverter
import java.util.stream.Collectors

class NoteTextConverter {

    @TypeConverter
    fun toText(noteText: List<String>): String {
        val a = noteText.stream()
        return noteText.stream().collect(Collectors.joining("\n"))
    }


    @TypeConverter
    fun toList(text: String): List<String> {
        return text.split("\n")
    }
}