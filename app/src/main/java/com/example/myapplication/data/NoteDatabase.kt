package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.model.Note
import com.example.myapplication.data.dao.NoteDao

@Database(entities = [Note::class], version = 1, exportSchema = false )
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}