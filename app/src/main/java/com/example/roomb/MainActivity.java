package com.example.roomb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomb.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtNhap;
    Button btnLuu;
    RecyclerView recylerDiaChi;
    ArrayList<Student> arrayList;
    private StudentAdapter studentAdapter;

    private void clickDeleteStudent(Student student) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc muốn xóa ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserDatabase.getInstance(MainActivity.this).userDAO().delete(student);
                        arrayList.remove(student);
                        studentAdapter = new StudentAdapter(arrayList, student -> clickDeleteStudent(student));
                        recylerDiaChi.setAdapter(studentAdapter);
                        Toast.makeText(MainActivity.this, "Xóa OK", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNhap = findViewById(R.id.txtNhap);
        btnLuu = findViewById(R.id.btnLuu);
        recylerDiaChi = findViewById(R.id.recylerDiaChi);
        recylerDiaChi.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recylerDiaChi.setLayoutManager(layoutManager);


        arrayList = new ArrayList<>();
        arrayList =(ArrayList<Student>) UserDatabase.getInstance(MainActivity.this).userDAO().getListStudent();
        //arrayList.add(new Student(1,"aa","Quận 8","0000"));
        studentAdapter = new StudentAdapter(arrayList, student -> clickDeleteStudent(student));
        recylerDiaChi.setAdapter(studentAdapter);

        btnLuu.setOnClickListener(v -> {
            Student s = new Student( txtNhap.getText().toString());
            UserDatabase.getInstance(MainActivity.this).userDAO().insertStudent(s);
            studentAdapter = null;
            arrayList.add(s);
            studentAdapter = new StudentAdapter(arrayList, student -> clickDeleteStudent(student));
            recylerDiaChi.setAdapter(studentAdapter);
        });
    }
}