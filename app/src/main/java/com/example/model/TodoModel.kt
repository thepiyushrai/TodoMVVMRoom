package com.example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName = "todoList")
data class TodoModel(
                     @ColumnInfo(name = "description")val description :String,
                     @ColumnInfo(name = "date")val date :String,



): Serializable {
    @PrimaryKey(autoGenerate = true) var id = 0

}