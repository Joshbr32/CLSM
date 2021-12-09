package com.example.clsm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView inventoryList;

    ArrayList<inventoryObject> inventoryObjects = new ArrayList<>();


    public class inventoryObject {
        String object_name, object_description;
        int object_count;

        inventoryObject(String obj_name, int obj_count, String obj_desc){
            object_name = obj_name;
            object_count = obj_count;
        }

        void addCount(){
            object_count++;
        }

        void subCount(){
            if(object_count > 0) {
                object_count--;
            }
        }

        public String getObjectName(){
            return object_name;
        }

        public String getObjectCount(){
            return String.valueOf(object_count);
        }


    }

    protected void readInventoryData(){

    }

    protected void writeInventoryData(){

    }

    protected void tempWriteArrayList(){
        inventoryObjects.add(new inventoryObject("Object A", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object B", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object H", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object E", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object F", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object G", 0, "Test Desc"));
        inventoryObjects.add(new inventoryObject("Object H", 0, "Test Desc"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        inventoryList = findViewById(R.id.inventoryList);

        tempWriteArrayList();

        InventoryAdapter inventoryAdapter = new InventoryAdapter(this, inventoryObjects);

        inventoryList.setAdapter(inventoryAdapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));
    }
}
