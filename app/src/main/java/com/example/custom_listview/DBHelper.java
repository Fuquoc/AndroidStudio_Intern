package com.example.custom_listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "PhuQuoc1.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String sql1 = "Drop table if exists DuLieu";
        //sqLiteDatabase.execSQL(sql1);
        String sql = "CREATE TABLE DuLieu(id INTEGER primary key AUTOINCREMENT, value INTEGER, pos varchar(100) not null)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS DuLieu";
        sqLiteDatabase.execSQL(sql);
    }

    public void insertData(int data,Integer position){
        SQLiteDatabase MySQl = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("value",data);
        contentValues.put("pos",position);
        MySQl.insert("DuLieu",null,contentValues);
    }

    public List<Integer> getData(Integer position){
        List<Integer> kq = new ArrayList<>();
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor =  MyDB.rawQuery("Select value from DuLieu where pos = ?",new String[]{position.toString()});
        if(cursor.getCount() == 0){
            return null;
        }else
        while (cursor.moveToNext()){
            System.out.println(cursor.getCount());
            Integer s = cursor.getInt(0);
            kq.add(s);
        }
        return kq;
    }
}
