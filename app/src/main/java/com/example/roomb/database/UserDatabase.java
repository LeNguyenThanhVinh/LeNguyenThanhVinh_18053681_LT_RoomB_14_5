package com.example.roomb.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomb.MainActivity;
import com.example.roomb.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "Student.db";
    private static com.example.roomb.database.UserDatabase instance;
    public static synchronized com.example.roomb.database.UserDatabase getInstance(MainActivity context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), com.example.roomb.database.UserDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract StudentDAO userDAO ();
}
