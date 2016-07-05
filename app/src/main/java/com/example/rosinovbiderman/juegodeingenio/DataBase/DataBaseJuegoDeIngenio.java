package com.example.rosinovbiderman.juegodeingenio.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseJuegoDeIngenio extends SQLiteOpenHelper {

    public DataBaseJuegoDeIngenio(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("SQLite", "Lolazo panini");
        String sqlCrearTabla;
        sqlCrearTabla = "create table jugadas (Nombre text, Clicks integer, Clieckeados text)";

        sqLiteDatabase.execSQL(sqlCrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
