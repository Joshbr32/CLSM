package com.example.clsm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Forms {
    String type, date, mainIdentifier;
    ArrayList<String> dataList = new ArrayList<String>();
    Context context;

    Forms(String formType, String formDate, String mainID){
        type = formType;
        date = formDate;
        mainIdentifier = mainID;
    }

    public void setContext(Context newContext) { context = newContext; }

    public void setType(String newType){
        type = newType;
    }

    public String getType(){
        return type;
    }

    public void setDate(String newDate){
        date = newDate;
    }

    public String getDate(){
        return date;
    }

    public void setMainIdentifier(String newMainID){
        mainIdentifier = newMainID;
    }

    public String getMainIdentifier(){
        return mainIdentifier;
    }

    public ArrayList<String> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<String>newData) {
        dataList = newData;
    }

    public String getDataSection(int dataPosition){
        return dataList.get(dataPosition);
    }

    public void setDataSection(String newData, int dataPosition){
        dataList.set(dataPosition, newData);
    }

    public void saveData(){
        if (mainIdentifier != null && date != null && context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

            Gson gson = new Gson();
            String json = gson.toJson(dataList);
            prefsEditor.putString(mainIdentifier + ";" + date, json);
            prefsEditor.commit();

            updateKeys(mainIdentifier + ";" + date);
        }
    }

    public ArrayList<String> loadData(){
        dataList = new ArrayList<String>();
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

            Gson gson = new Gson();
            String json = sharedPreferences.getString(mainIdentifier + ";" + date, null);
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            dataList = gson.fromJson(json, type);
        }
        return dataList;
    }

    public void updateKeys(String key) {
        ArrayList<String> keyList;

        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("keyList", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        keyList = gson.fromJson(json, type);

        if (keyList == null) {
            keyList = new ArrayList<String>();
        }
        if (!keyList.contains(key)) {
            keyList.add(key);
            json = gson.toJson(keyList);
            prefsEditor.putString("keyList", json);
            prefsEditor.commit();
        }
    }
}
