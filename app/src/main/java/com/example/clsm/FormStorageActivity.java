package com.example.clsm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class FormStorageActivity extends AppCompatActivity {
    RecyclerView formList;
    ArrayList<Forms> formSheets = new ArrayList<>(), worksheets = new ArrayList<>(), timesheets = new ArrayList<>();
    StorageAdapter storageAdapter;
    CheckBox ts, ws;
    Boolean tsIncluded = true, wsIncluded = true;

    protected void tempFormList(){
        formSheets.add(new Forms("TimeSheet", "09092000", "Obj 1"));
        formSheets.add(new Forms("WorkSheet", "09092000", "Obj 2"));
        formSheets.add(new Forms("TimeSheet", "09092000", "Obj 3"));
        formSheets.add(new Forms("WorkSheet", "09092000", "Obj 4"));

        worksheets.add(formSheets.get(1));
        worksheets.add(formSheets.get(2));

        createFormLists();
    }

    protected void createFormLists(){
        ArrayList<String> keyList;
        ArrayList<String> dataList;
        String[] key;
        Forms form;

        // Search saved file for all the Work Sheets and all the time sheets.
        keyList = getKeyList();

        for (int i = 0; i < keyList.size(); i++) {
            key = keyList.get(i).toString().split(";");
            Log.i("Forms", keyList.get(i).toString());
            Log.i("Forms", key[key.length - 1].toString());
            Log.i("Forms", key[0].toString());
            dataList = loadForm(keyList.get(i).toString());
            Log.i("Forms", dataList.get(0).toString());
            form = new Forms(dataList.get(0).toString(), key[key.length - 1].toString(), key[0].toString());

            if (Objects.equals(dataList.get(0).toString(), "WorkSheet")) {
                worksheets.add(form);
            } else if (Objects.equals(dataList.get(0).toString(), "TimeSheet")) {
                timesheets.add(form);
            }
            formSheets.add(form);

        }
        //
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_storage);

        formList = findViewById(R.id.formsList);
        ts = findViewById(R.id.formstorage_form_type_timesheet_button);
        ws = findViewById(R.id.formstorage_form_type_worksheet_button);

        tempFormList();

        storageAdapter = new StorageAdapter(this, formSheets);

        formList.setAdapter(storageAdapter);
        formList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void toggleWS(View view) {
        updateLists();
    }

    public void toggleTS(View view) {
        updateLists();
    }

    public void updateLists(){
        if( ts.isChecked() && !tsIncluded ){
            // Add timesheets to array
            formSheets.addAll(timesheets);
            tsIncluded = true;
        }
        else if( !ts.isChecked() && tsIncluded){
            // remove timeSheets
            formSheets.removeAll(timesheets);

            tsIncluded = false;
        }

        if( ws.isChecked() && !wsIncluded ){
            // Add work to array
            formSheets.addAll(worksheets);
            wsIncluded = true;
        }
        else if( !ws.isChecked() && wsIncluded){
            // remove work
            formSheets.removeAll(worksheets);
            wsIncluded = false;
        }
        storageAdapter.notifyDataSetChanged();
    }

    protected ArrayList<String> getKeyList() {
        ArrayList<String> keyList;

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("keyList", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        keyList = gson.fromJson(json, type);

        if (keyList == null) {
            keyList = new ArrayList<String>();
        }

        return keyList;
    }

    protected ArrayList<String> loadForm(String key) {
        ArrayList<String> dataList;

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        dataList = gson.fromJson(json, type);

        return dataList;
    }
}
