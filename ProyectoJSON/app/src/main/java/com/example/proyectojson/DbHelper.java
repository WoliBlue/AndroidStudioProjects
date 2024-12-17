package com.example.proyectojson;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// CLASE PARA CREAR LA BASE DE DATOS
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="fruta.db";
    public static final String TABLE_FRUTAS="t_frutas";


    //  constructor de la clase DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

// CREAR LA BASE DE DATOS

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_FRUTAS + "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " + "cantidad INT NOT NULL)");

    }
    // ACTUALIZAR LA BASE DE DATOS
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRUTAS);
        onCreate(db);
    }

    // CERRAR LA BASE DE DATOS
    public void close (SQLiteDatabase db) {
        if (db != null) {
            db.close();
        }
    }

    // INSERTAR DATOS EN LA BASE DE DATOS
    public void insertar (Fruta fruta, SQLiteDatabase db) {
        ContentValues cv1 = new ContentValues();

        cv1.put("nombre", fruta.getNombre());
        cv1.put("cantidad", fruta.getUnidades());

        db.insert(TABLE_FRUTAS, null, cv1);

    }


    /*
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }
*/


}

