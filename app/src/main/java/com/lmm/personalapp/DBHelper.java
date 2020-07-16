package com.lmm.personalapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"dbpapp",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table1 = "CREATE TABLE tasks(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,date TEXT,complete BOOLEAN)";
        db.execSQL(table1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
