package com.example.model

import androidx.lifecycle.LiveData

class ToDoNoteRepository (private val notesDao: TodoListDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allNotes: LiveData<List<TodoModel>> = notesDao.getAllTodoList()

    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(note: TodoModel) {
        notesDao.insertTask(note)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(note: TodoModel){
        notesDao.deleteTask(note)
    }

    // on below line we are creating a update method for
    // updating our note from database.
    suspend fun update(note: TodoModel){
        notesDao.updateTaskStatus(note)
    }
}