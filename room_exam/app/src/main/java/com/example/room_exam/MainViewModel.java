package com.example.room_exam;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    //로직과 UI 분리
    //이곳에서 로직 구현

   private AppDatabase db;
   public LiveData<List<Todo>> todos;
   public String newTodo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db").build();

        todos = getAll();
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }

    public void insert(String todo){
        new InsertAsyncTask(db.todoDao()).execute(new Todo(todo));
    }

    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void>{
        private ToDoDao mTodoDao;

        public InsertAsyncTask(ToDoDao todoDao){
            this.mTodoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }
    }
}
