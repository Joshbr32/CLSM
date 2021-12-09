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