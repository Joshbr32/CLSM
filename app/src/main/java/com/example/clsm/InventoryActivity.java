package com.example.clsm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView inventoryList;
    InventoryAdapter inventoryAdapter;
    ArrayList<inventoryObject> inventoryObjects = new ArrayList<>();




    public static class inventoryObject extends Forms{
        String object_description;
        int object_count;

        /*
        Data List Order:
            Type
            Name
            Count
            Description
         */

        inventoryObject(String obj_name, int obj_count, String obj_desc){
            super("InventoryItem", "null", obj_name);

            // Additional Data \\
            object_count = obj_count;
            object_description = obj_desc;
        }

        void addCount(){
            object_count++;
        }

        void subCount(){
            if(object_count > 0) {
                object_count--;
            }
        }

        public String getObjectCount(){
            return String.valueOf(object_count);
        }

        void createDataList(){
            ArrayList<String> dl = new ArrayList<>();

            dl.add(type);
            dl.add(mainIdentifier);
            dl.add(String.valueOf(object_count));
            dl.add(object_description);

            setDataList(dl);
        }

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

        inventoryAdapter = new InventoryAdapter(this, inventoryObjects);

        inventoryList.setAdapter(inventoryAdapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));

    }

    /*
    public void createItem(View view) {
        inventoryObjects.add(new inventoryObject("Object A", 0, "Test Desc"));
        inventoryAdapter.notifyDataSetChanged();
    }
     */

    public void switchToAddItemActivity(View view) {
        Intent intent= new Intent(this, AddInventoryItem.class);
        startActivity(intent);
    }
}
