package com.example.clsm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView inventoryList;
    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        inventoryList = findViewById(R.id.inventoryList);

        s1= getResources().getStringArray(R.array.inventory_objects);
        s2= getResources().getStringArray(R.array.inventory_descriptions);

        InventoryAdapter inventoryAdapter = new InventoryAdapter(this, s1, s2);
        inventoryList.setAdapter(inventoryAdapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));
    }
}