package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.model.ToDoDatabase
import com.example.model.ToDoNoteRepository
import com.example.model.TodoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<TodoModel>>
    val repository : ToDoNoteRepository

    // on below line we are initializing
    // our dao, repository and all notes
    init {
        val dao = ToDoDatabase.getDatabase(application).getToDoDao()
        repository = ToDoNoteRepository(dao)
        allNotes = repository.allNotes
    }
    fun deleteNote (note: TodoModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    // on below line we are creating a new method for updating a note. In this we are
    // calling a update method from our repository to update our note.
    fun updateNote(note: TodoModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }


    // on below line we are creating a new method for adding a new note to our database
    // we are calling a method from our repository to add a new note.
    fun addToDoNote(note: TodoModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note)
        }
    }

}