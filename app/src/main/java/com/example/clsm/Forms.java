package com.example.clsm;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

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

    public void setContext(Context newContext) {
        context = newContext;
    }

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
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(dataList);
        prefsEditor.putString(mainIdentifier, json);
        prefsEditor.commit();
    }

    public ArrayList<String> loadData(){
        ArrayList<String> loadedDataList = new ArrayList<String>();

        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString(mainIdentifier, "");
        dataList = gson.fromJson(json, dataList.getClass());

        return loadedDataList;
    }
}
