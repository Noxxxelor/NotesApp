package com.example.notesapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete
import androidx.room.Query
import com.example.notesapp.data.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("select * from notes order by timestamp Desc")
    fun getAllNotes(): LiveData<List<Note>>
}