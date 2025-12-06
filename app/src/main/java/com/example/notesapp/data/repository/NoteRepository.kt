package com.example.notesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val dao : NoteDao) {
    suspend fun upsert(note: Note){
        dao.upsert(note)
    }

    suspend fun delete(note: Note){
        dao.delete(note)
    }

    fun getAllNotes(): LiveData<List<Note>> = dao.getAllNotes()
}