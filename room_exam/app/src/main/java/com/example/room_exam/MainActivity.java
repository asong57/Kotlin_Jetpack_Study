package com.example.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db").allowMainThreadQueries().build();
        //디비 객체 생성
        //allowMainThreadQueries()는 백그라운드 뿐만아니라 메인스레드에서도 디비가 동작하도록 한다.

        mResultTextView.setText(db.todoDao().getAll().toString());

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
                mResultTextView.setText(db.todoDao().getAll().toString());

            }
        });


    }
}