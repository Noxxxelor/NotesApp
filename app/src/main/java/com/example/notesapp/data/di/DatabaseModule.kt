package com.example.notesapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: NoteDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideRepository(dao: NoteDao): NoteRepository {
        return NoteRepository(dao)
    }
}