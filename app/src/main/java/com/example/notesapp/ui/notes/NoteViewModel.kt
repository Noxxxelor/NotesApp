package com.example.notesapp.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.data.model.Note

class NoteViewModel(private val repository : NoteRepository) : ViewModel() {
    val notesLiveData = MutableLiveData<List<Note>>()

    fun loadNotes(){
        val list = repository.getAllNotes()
        notesLiveData.value = list
    }

    fun addNote(note: Note){
        repository.insert(note)
        loadNotes()
    }

    fun deleteNote(note: Note){
        repository.delete(note)
        loadNotes()
    }

    fun updateNote(note: Note){
        repository.update(note)
        loadNotes()
    }
}