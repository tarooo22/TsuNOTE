package com.pinaluri.TNote.ui.show

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinaluri.TNote.local.NoteDatabase
import com.pinaluri.TNote.local.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowNoteViewModel : ViewModel() {

    private val database = NoteDatabase.getInstance()
    private val _note = MutableLiveData<Note>()
    val note = _note

    fun update(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            database.noteDAO().updateNote(note)
        }
    }

    fun getNote(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            _note.postValue(database.noteDAO().getNoteById(id))
        }
    }

    fun deleteNote(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            database.noteDAO().deleteNote(id)
        }
    }
}