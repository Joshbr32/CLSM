package com.example.clsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.gesture.GestureLibrary;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    GestureLibrary lib;

    protected static final String ACTIVITY_NAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomTool = findViewById(R.id.bottom_toolbar);
        bottomTool.setOnNavigationItemSelectedListener(toolListener);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener toolListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.stopwatch:
                    selectedFragment = new StopwatchFragment();
                    break;
                case R.id.filing:
                    selectedFragment = new FilingCabinetFragment();
                    break;
                case R.id.clipboard:
                    selectedFragment = new ClipboardFragment();
                    break;
                case R.id.questions:
                    selectedFragment = new QuestionFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        }
    };
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        //(myToolbar);
        //Toolbar toolbar =  findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);
        //Toolbar toolbar = findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);







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