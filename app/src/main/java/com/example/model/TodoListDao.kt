package com.example.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface  TodoListDao {

    @Insert
    suspend fun insertTask(task : TodoModel) : Long

    @Update
    suspend fun updateTaskStatus(task: TodoModel) : Int



    @Delete
    suspend fun deleteTask(task: TodoModel)

    @Query("Select * from todoList order by id ASC")
    fun getAllTodoList(): LiveData<List<TodoModel>>
}