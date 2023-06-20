package com.pinaluri.TNote.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinaluri.TNote.local.NoteDatabase
import com.pinaluri.TNote.local.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    private val database = NoteDatabase.getInstance()

    fun insert(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            database.noteDAO().insert(note)
        }
    }
}