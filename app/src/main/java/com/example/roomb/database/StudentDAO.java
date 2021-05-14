package com.example.roomb.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.roomb.Student;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    void insertStudent(Student student);

    @Query("SELECT * FROM Student")
    List<Student> getListStudent();

    @Delete
    void delete(Student student);
}
