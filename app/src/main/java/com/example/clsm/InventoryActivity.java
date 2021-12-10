package com.example.clsm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView inventoryList;
    InventoryAdapter inventoryAdapter;
    ArrayList<inventoryObject> inventoryObjects;

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

        for (int i = 0; i < inventoryObjects.size(); i++) {
            inventoryObjects.get(i).saveData();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_inventory);

        inventoryList = findViewById(R.id.inventoryList);

        inventoryObjects = new ArrayList<>();
        loadSavedItems();
        tempWriteArrayList();

        inventoryAdapter = new InventoryAdapter(this, inventoryObjects);

        inventoryList.setAdapter(inventoryAdapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));

        if (extras != null) {
            String data = extras.getString("item");
            String[] item_tokens = data.split(";");

            if (item_tokens.length == 3) {
                createItem(item_tokens[0], Integer.parseInt(item_tokens[1]), item_tokens[2]);
            }
        }
    }

    public void createItem(String name, int count, String desc) {
        inventoryObject item = new inventoryObject(name, count, desc);
        item.setContext(this);
        item.saveData();
        inventoryObjects.add(item);
        inventoryAdapter.notifyDataSetChanged();
    }

    public void switchToAddItemActivity(View view) {
        Intent intent = new Intent(this, AddInventoryItem.class);
        startActivity(intent);
    }

    public void loadSavedItems() {
        ArrayList<String> keyList;
        ArrayList<String> dataList;
        String[] key;
        Forms item;

        // Search saved file for all the Work Sheets and all the time sheets.
        keyList = getKeyList();

        for (int i = 0; i < keyList.size(); i++) {
            key = keyList.get(i).toString().split(";");
            if (key.length > 1) {
                dataList = loadForm(keyList.get(i).toString());
                if (dataList == null) {
                    continue;
                } else {
                    if (dataList.size() < 3) {
                        continue;
                    } else {
                        try {
                            Integer.parseInt(dataList.get(2));
                        } catch (final NumberFormatException e) {
                            continue;
                        }
                    }
                        inventoryObjects.add(new inventoryObject(dataList.get(0).toString(), Integer.parseInt(dataList.get(2)), key[0].toString()));
                    }

            }
        }
    }

    protected ArrayList<String> getKeyList() {
        ArrayList<String> keyList;

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("keyList", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        keyList = gson.fromJson(json, type);

        if (keyList == null) {
            keyList = new ArrayList<String>();
        }

        return keyList;
    }

    protected ArrayList<String> loadForm(String key) {
        ArrayList<String> dataList;

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        dataList = gson.fromJson(json, type);

        return dataList;
    }

    public void onBackPressed() {
        Intent setIntent = new Intent(this, MainActivity.class);
        startActivity(setIntent);
    }
}
