package com.example.clsm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class WorkOrderActivity extends AppCompatActivity {

    Spinner siteSpinner;
    EditText dateField, timeInField, timeOutField, commentsField;
    ListView taskList;
    Bundle workOrderBundle;
    ArrayList<WorkOrder> workOrders;
    WorkOrder workOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order);

        siteSpinner = findViewById(R.id.spinner);
        dateField = findViewById(R.id.editTextDate2);
        timeInField = findViewById(R.id.editTextTime3);
        timeOutField = findViewById(R.id.editTextTime4);
        commentsField = findViewById((R.id.commentsField));
        taskList = findViewById(R.id.taskList);

        // Populate site spinner
        String[] sites = new String[]{"@string/site_1", "@string/site_2", "@string/site_3", "@string/site_4", "@string/site_5"};
        ArrayAdapter<String> siteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sites);
        siteSpinner.setAdapter(siteAdapter);

        // Populate task listView
        String[] tasks = new String[]{"@string/task_1", "@string/task_2", "@string/task_3", "@string/task_4", "@string/task_5"};
        ArrayAdapter<String> taskAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, tasks);
        taskList.setAdapter(taskAdapter);

    }

    public class WorkOrder {
        String orderSite, orderDate, orderTimeIn, orderTimeOut, orderComment;
        String[] orderCompletedTasks;

        WorkOrder(String site, String date, String timeIn, String timeOut, String[] completedTasks, String comment) {
            orderSite = site;
            orderDate = date;
            orderTimeIn = timeIn;
            orderTimeOut = timeOut;
            orderCompletedTasks = completedTasks;
            orderComment = comment;
        }

    }

    private class saveData extends AsyncTask<Void, Void, Void> {
        String site, date, timeIn, timeOut, comment;
        String[] completedTasks;

        @Override
        protected Void doInBackground(Void... voids) {
            site = siteSpinner.getSelectedItem().toString();
            date = dateField.getText().toString();
            timeIn = timeInField.getText().toString();
            timeOut = timeOutField.getText().toString();
            comment = commentsField.getText().toString();

            // get checked tasks from listview

            workOrder = new WorkOrder(site, date, timeIn, timeOut, completedTasks, comment);

            // Save work order data
            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

            /* I had to comment this out as it was giving errors
            Gson gson = new Gson();
            String json = gson.ToJson(workOrder);
            prefsEditor.putString("workOrder", json);
            */

            prefsEditor.commit();

            // Retrieval code
            /*
            Gson gson = new Gson();
            String json = mPrefs.getString("workOrder", "");
            MyObject obj = gson.fromJson(json, workOrder.class);
            */

            return null;
        }
    }
}
