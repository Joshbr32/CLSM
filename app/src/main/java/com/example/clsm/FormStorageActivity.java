package com.example.clsm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FormStorageActivity extends AppCompatActivity {
    RecyclerView formList;
    ArrayList<Forms> formSheets = new ArrayList<>();

    protected void tempFormList(){
        formSheets.add(new Forms("Test", "09092000", "Obj 1"));
        formSheets.add(new Forms("Test", "09092000", "Obj 2"));
        formSheets.add(new Forms("Test", "09092000", "Obj 3"));
        formSheets.add(new Forms("Test", "09092000", "Obj 4"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_storage);

        formList = findViewById(R.id.formsList);

        tempFormList();

        StorageAdapter storageAdapter = new StorageAdapter(this, formSheets);

        formList.setAdapter(storageAdapter);
        formList.setLayoutManager(new LinearLayoutManager(this));


    }
}
