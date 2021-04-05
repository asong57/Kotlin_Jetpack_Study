package com.example.room_exam_koglin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
val viewModel: MainViewModel by viewModels()
    val mainAndroidViewModel: MainAndroidViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAll().observe(this, Observer {
            result_text.text = it.toString()
        })
        //자동으로 관찰가능하게 한다.

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                viewModel.insert(Todo(todo_edit.text.toString()))
            }

        }

    }
}