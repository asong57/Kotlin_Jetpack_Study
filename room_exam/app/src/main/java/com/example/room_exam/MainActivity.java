package com.example.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

        MainViewModel viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainViewModel.class);

        //UI 갱신
        viewModel.getAll().observe(this, todos -> {
            mResultTextView.setText(todos.toString());
        });
        //db에서 그때그때 확인하는 것이 아니라 LiveData를 활용하여 todos인자로 확인
        //UI갱신을 개발자가 갱신해주는 것이 아니라 자동으로 갱신해준다.


        //버튼 클릭시 DB에 insert
        findViewById(R.id.add_button).setOnClickListener(v -> {
            viewModel.insert(new Todo(mTodoEditText.getText().toString()));
        });
    }
}