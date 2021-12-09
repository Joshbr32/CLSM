package com.example.clsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void timesheet(View view) {
        Log.i(ACTIVITY_NAME,"made it");
        Toast toast = Toast.makeText(getApplicationContext(), "Opens up timesheet",Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this,TimeSheetActivity.class);
        startActivity(intent);

    }


    public void worksheet(View view) {
        Log.i(ACTIVITY_NAME,"made it");
        Toast toast = Toast.makeText(MainActivity.this, "Opens up worksheet",Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, WorkSheetActivity.class);
        startActivity(intent);
    }


    public void workOrder(View view) {
        Log.i(ACTIVITY_NAME,"made it");
        Toast toast = Toast.makeText(MainActivity.this, "Opens up work order",Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this,WorkOrderActivity.class);
        startActivity(intent);
    }


    public void inventory(View view) {
        Log.i(ACTIVITY_NAME,"made it");
        Toast toast = Toast.makeText(MainActivity.this, "Opens up inventory",Toast.LENGTH_LONG);
        toast.show();
        Intent intent= new Intent(this,InventoryActivity.class);
        startActivity(intent);
    }


    public void formStorage(View view) {
        Toast toast = Toast.makeText(MainActivity.this, "Opens up form storage",Toast.LENGTH_LONG);
        toast.show();
        Intent intent= new Intent(this, TimeSheetActivity.class);
        startActivity(intent);
    }
}