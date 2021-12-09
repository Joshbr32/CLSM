package com.example.clsm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CLSMDatabase.db";
    private static final int VERSION_NUM = 1;

    public static final String WORK_ORDER_TABLE_NAME = "work_order";
    public static final String KEY_ID = "_id";
    public static final String KEY_SITE = "site";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME_IN = "time_in";
    public static final String KEY_TIME_OUT = "time_out";
    public static final String KEY_TASK_1 = "task_1";
    public static final String KEY_TASK_2 = "task_2";
    public static final String KEY_TASK_3 = "task_3";
    public static final String KEY_TASK_4 = "task_4";
    public static final String KEY_TASK_5 = "task_5";
    public static final String KEY_COMMENTS = "comments";

    private static final String WORK_ORDER_DATABASE_CREATE = "create table "
            + WORK_ORDER_TABLE_NAME + "("
            + KEY_ID + " integer primary key autoincrement, "
            + KEY_SITE + " text, "
            + KEY_DATE + " text, "
            + KEY_TIME_IN + " text, "
            + KEY_TIME_OUT + " text, "
            + KEY_TASK_1 + " text, "
            + KEY_TASK_2 + " text, "
            + KEY_TASK_3 + " text, "
            + KEY_TASK_4 + " text, "
            + KEY_TASK_5 + " text, "
            + KEY_COMMENTS + " text);";

    public databaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(WORK_ORDER_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
