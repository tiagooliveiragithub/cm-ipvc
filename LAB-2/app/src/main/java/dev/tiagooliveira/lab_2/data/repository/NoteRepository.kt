package dev.tiagooliveira.lab_2.data.repository

import androidx.lifecycle.LiveData
import dev.tiagooliveira.lab_2.data.dao.NoteDao
import dev.tiagooliveira.lab_2.data.entities.Note

class NoteRepository(private  val noteDao: NoteDao) {
    val readAllNotes : LiveData<List<Note>> = noteDao.readAllNotes()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}