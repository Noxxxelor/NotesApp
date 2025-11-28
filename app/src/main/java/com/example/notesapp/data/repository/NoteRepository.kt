package com.example.notesapp.data.repository

import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.model.Note

class NoteRepository (private val dao : NoteDao) {
    fun insert(note: Note){
        dao.insert(note)
    }

    fun update(note: Note){
        dao.update(note)
    }

    fun delete(note: Note){
        dao.delete(note)
    }

    fun getAllNotes(): List<Note>{
        return dao.getAllNotes()
    }
}