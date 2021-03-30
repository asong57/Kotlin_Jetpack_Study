package com.example.room_exam_koglin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name")
            .allowMainThreadQueries().build()

        db.todoDao().getAll().observe(this, Observer {
            result_text.text = it.toString()
        })
        //자동으로 관찰가능하게 한다.

        add_button.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
        }

    }
}