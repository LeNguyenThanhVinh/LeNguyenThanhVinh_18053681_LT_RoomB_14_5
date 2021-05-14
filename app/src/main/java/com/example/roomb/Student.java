package com.example.roomb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String address;


    public Student( String address) {

        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
