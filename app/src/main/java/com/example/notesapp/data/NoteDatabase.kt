package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.data.model.Note
import com.example.notesapp.data.dao.NoteDao

@Database([Note::class], version =1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}