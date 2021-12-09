package com.example.clsm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TimePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_page);
        TextView n1,t1,t2,d1,s1;
        n1 = findViewById(R.id.time_name2);
        t1 = findViewById(R.id.time_in2);
        t2 = findViewById(R.id.time_out2);
        d1 = findViewById(R.id.time_date2);
        s1 = findViewById(R.id.time_supervisor2);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("preference", Context.MODE_PRIVATE);

        String supervisor = sharedPreferences.getString("supervisor name", "");
        String name = sharedPreferences.getString("name", "");
        String timeIn = sharedPreferences.getString("time in","");
        String timeOut = sharedPreferences.getString("time out","");
        String date = sharedPreferences.getString("date","");

        n1.setText(name);
        t1.setText(timeIn);
        t2.setText(timeOut);
        d1.setText(date);
        s1.setText(supervisor);

    }

}

class TimeSheet extends Forms{

    // Main identifier is Name

    // Addtional Data
    String timeIn, timeOut, supervisor;


    TimeSheet(String n1, String t1, String t2, String d1, String s1){
        super("TimeSheet", "d1", "n1");
        timeIn = t1;
        timeOut = t2;
        supervisor = s1;
    }

    void createDataList(){
        /*
        Order:
            Type
            Name
            Date
            Supervisor
            TimeIn
            TimeOut
         */
        ArrayList<String> dl = new ArrayList<>();
        dl.add(type);
        dl.add(supervisor);
        dl.add(mainIdentifier);
        dl.add(timeIn);
        dl.add(timeOut);
        dl.add(date);

        setDataList(dl);
    }
}