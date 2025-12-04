package com.example.notesapp.ui.notes

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.data.model.Note
import kotlinx.coroutines.launch

class NoteViewModel(private val repository : NoteRepository) : ViewModel() {
    val notesLiveData = repository.getAllNotes()
    fun addNote(note: Note){
        viewModelScope.launch {
            repository.insert(note)
        }

    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.delete(note)
        }

    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            repository.update(note)
        }

    }
}