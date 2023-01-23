package com.example.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase




@Database(entities = arrayOf(TodoModel::class), version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun getToDoDao(): TodoListDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToDoDatabase::class.java, "todo_database"
            ).build()
    }


//  //  companion object {
//        // Singleton prevents multiple
//        // instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: ToDoDatabase? = null
//
//        fun getDatabase(context: Context): ToDoDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ToDoDatabase::class.java,
//                    "note_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}