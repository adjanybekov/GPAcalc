package com.blogspot.adjanybekov.gpacalculator.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 17/08/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }




    public static final String ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREDIT = "credit";
    public static final String COLUMN_GRADE = "grade";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDataBase";
    public static final String DATABASE_TABLE = "gpaTable";


    public DataBase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE + " (" +
                    ID + " integer primary key autoincrement, " +
                    COLUMN_NAME + " text not null, "+
                    COLUMN_GRADE + " integer not null, " +
                    COLUMN_CREDIT + " integer not null);";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }


    public final List getAllData() {
        SQLiteDatabase database = getWritableDatabase();
        List nameList = new ArrayList<>();
        String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE 1";
        Cursor cursor = database.rawQuery(query, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long id = cursor.getLong(0);
            String name = cursor.getString(1);
            nameList.add(name);
            cursor.moveToNext();
        }
        cursor.close();
        return nameList;
    }


}
