package com.example.clsm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimeSheetActivity extends AppCompatActivity {

    EditText name,timeIn,timeOut,date,sv;
    Button save,page;
    SharedPreferences sharedPreferences;
    String n1,t1,t2,d1,s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);

        name = findViewById(R.id.TimeName1);
        sv = findViewById(R.id.timeSupervisor1);
        timeIn = findViewById(R.id.TimeIn1);
        timeOut = findViewById(R.id.TimeOut1);
        date = findViewById(R.id.TimeDate1);
        save = findViewById(R.id.time_save);
        page = findViewById(R.id.time_clear);

        sharedPreferences = getSharedPreferences("preference", Context.MODE_PRIVATE);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create new TimeSheet from class
                n1 = name.getText().toString();
                t1 = timeIn.getText().toString();
                t2 = timeOut.getText().toString();
                d1 = date.getText().toString();
                s1 = sv.getText().toString();

                saveForm();

                Toast.makeText(TimeSheetActivity.this, "Time Successfully Logged!", Toast.LENGTH_LONG).show();


            }
        });
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeSheetActivity.this, TimePage.class);
                startActivity(intent );



            }
        });
    }

    public void saveForm(){
        TimeSheet newTimesheet = new TimeSheet(
            n1 = name.getText().toString(),
            t1 = timeIn.getText().toString(),
            t2 = timeOut.getText().toString(),
            d1 = date.getText().toString(),
            s1 = sv.getText().toString()
        );

        newTimesheet.createDataList();
        newTimesheet.setContext(this);
        newTimesheet.saveData();
    }


}