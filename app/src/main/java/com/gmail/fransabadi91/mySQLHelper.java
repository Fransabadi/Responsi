package com.gmail.fransabadi91;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class mySQLHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table name
    public static final String TABLE = "data";

    // Columns
    public static final String nama = "nama";
    public static final String nim = "nim";
    public static final String jurusan = "jurusan";
    public static final String jk1 = "jenis_kelamin";
    public static final String foto = "foto";


    public mySQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE + "( _id"+ " integer primary key autoincrement, " + nim + " text not null, "
                + nama + " text not null,  "+jurusan +"text not null, " + jk1 + "text not null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}