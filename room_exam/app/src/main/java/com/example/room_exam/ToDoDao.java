package com.example.room_exam;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDao {
    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAll();
    //LiveData : 관찰가능한 객체가 된다.

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);
}
