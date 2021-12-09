package com.example.clsm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
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

