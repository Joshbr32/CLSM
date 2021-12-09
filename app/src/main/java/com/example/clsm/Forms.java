package com.example.clsm;

import java.util.ArrayList;

public class Forms {
    String type, date, mainIdentifier;
    ArrayList<String> dataList = new ArrayList<String>();

    Forms(String formType, String formDate, String mainID){
        type = formType;
        date = formDate;
        mainIdentifier = mainID;
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

    public void saveData(){

    }

    public String getDataSection(int dataPosition){
        return dataList.get(dataPosition);
    }

    public ArrayList<String> loadData(){
        ArrayList<String> loadedDataList = new ArrayList<String>();


        return loadedDataList;
    }
}
