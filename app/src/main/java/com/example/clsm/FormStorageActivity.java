package com.example.clsm;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
    }

    protected void createFormLists(){
        // Search saved file for all the Work Sheets and all the time sheets.
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
}
