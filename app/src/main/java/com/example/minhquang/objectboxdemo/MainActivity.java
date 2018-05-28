package com.example.minhquang.objectboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.minhquang.objectboxdemo.Models.Student;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnInsert;
    EditText edt;
    BoxStore boxStore;
    Box<Student> studentBox;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initList();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                edt.setText("");
                initList();
            }
        });


    }

    private void insert() {
        if (!TextUtils.isEmpty(edt.getText().toString().trim())) {
            studentBox.put(new Student(edt.getText().toString().trim()));
        }
    }

    private void initList() {
        List<Student> listStudents;
        boxStore = App.getApp().getBoxStore();
        studentBox = boxStore.boxFor(Student.class);
        listStudents = studentBox.getAll();


        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < listStudents.size(); i++) {
            temp.add(listStudents.get(i).getName());
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp);
        listView.setAdapter(arrayAdapter);
    }

    private void initView() {
        edt = findViewById(R.id.edt);
        listView = findViewById(R.id.listview);
        btnInsert = findViewById(R.id.btnInsert);
    }
}
