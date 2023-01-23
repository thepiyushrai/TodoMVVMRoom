package com.example.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.model.TodoModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    private lateinit var viewModal: ToDoViewModel
    private lateinit var binding: ActivityMainBinding
//    val viewModel : ToDoViewModel by viewModels()
    lateinit var viewModal: ToDoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
   initv()
//    }

//    private fun init() {
//        //on below line we are initializing our view modal.
//        viewModal = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(ToDoViewModel::class.java)
//      binding.clickbtn.setOnClickListener {
//          viewModal.addToDoNote(TodoModel("Hi", "There"))
//          Toast.makeText(this, "To Do Note Added", Toast.LENGTH_LONG).show()
//      }
//    }


}

    private fun initv() {

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ToDoViewModel::class.java)

      binding.clickbtn.setOnClickListener {
          viewModal.addToDoNote(TodoModel("Hi", "There"))
          Toast.makeText(this, "To Do Note Added", Toast.LENGTH_LONG).show()
      }
    }
    }
