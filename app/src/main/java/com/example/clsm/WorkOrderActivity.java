package com.example.clsm;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class WorkOrderActivity extends AppCompatActivity {

    Spinner siteSpinner;
    EditText dateField, timeInField, timeOutField, commentsField;
    ListView taskList;
    Bundle workOrderBundle;
    ArrayList<WorkOrder> workOrders;
    WorkOrder workOrder;
    Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order);

        siteSpinner = findViewById(R.id.spinner);
        dateField = findViewById(R.id.editTextDate2);
        timeInField = findViewById(R.id.editTextTime3);
        timeOutField = findViewById(R.id.editTextTime4);
        commentsField = findViewById(R.id.commentsField);
        taskList = findViewById(R.id.taskList);
        saveButton = findViewById(R.id.saveButton);

        // Populate site spinner
        String[] sites = new String[]{getResources().getString(R.string.site_1), getResources().getString(R.string.site_2), getResources().getString(R.string.site_3), getResources().getString(R.string.site_4), getResources().getString(R.string.site_5)};
        ArrayAdapter<String> siteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sites);
        siteSpinner.setAdapter(siteAdapter);

        // Populate task listView
        String[] tasks = new String[]{getResources().getString(R.string.task_1), getResources().getString(R.string.task_2), getResources().getString(R.string.task_3), getResources().getString(R.string.task_4), getResources().getString(R.string.task_5)};
        ArrayAdapter<String> taskAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, tasks);
        taskList.setAdapter(taskAdapter);

        workOrder = new WorkOrder(dateField.getText().toString(), siteSpinner.getSelectedItem().toString());
        workOrder.setContext(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData sd = new SaveData();
                sd.execute();
            }
        });
    }

    public class WorkOrder extends Forms {
        WorkOrder(String formDate, String mainID) {
            super("WorkSheet", formDate, mainID);
        }
    }

    private class SaveData extends AsyncTask<Void, Void, Void> {
        String completedTasks;
        ArrayList<String> dataList;

        @Override
        protected Void doInBackground(Void... voids) {
            // Get checked task items
            completedTasks = "";
            for (int i = 0; i < taskList.getCount(); i++) {
                if (taskList.isItemChecked(i)) {
                    completedTasks += taskList.getItemAtPosition(i).toString() + ";";
                }
            }

            // Update workOrder
            dataList = new ArrayList<String>();

            workOrder.setMainIdentifier(siteSpinner.getSelectedItem().toString());
            workOrder.setDate(dateField.getText().toString());
            dataList.add("workOrder");
            dataList.add(timeInField.getText().toString());
            dataList.add(timeOutField.getText().toString());
            dataList.add(completedTasks);
            dataList.add(commentsField.getText().toString());
            workOrder.setDataList(dataList);

            // Save data
            workOrder.saveData();

            return null;
        }
    }
}