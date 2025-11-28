package com.example.notesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
data class Note (
    @PrimaryKey
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val timestamp : Long = System.currentTimeMillis()
)