package com.example.clsm;

import java.util.ArrayList;

public abstract class Forms {
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

    public ArrayList<String> loadData(){
        ArrayList<String> loadedDataList = new ArrayList<String>();


        return loadedDataList;
    }
}
/*
class WorkOrder extends Forms {
    String orderSite, orderDate, orderTimeIn, orderTimeOut, orderComment;
    String[] orderCompletedTasks;

    WorkOrder(String site, String date, String timeIn, String timeOut, String[] completedTasks, String comment) {

        //orderSite = site;
        //orderDate = date;

        // Main Data \\
        super("WorkOrder", date, site);

        // Additional Data that goes into the dataList arrayList \\
        orderTimeIn = timeIn;
        orderTimeOut = timeOut;
        orderCompletedTasks = completedTasks;
        orderComment = comment;
    }
}
 */