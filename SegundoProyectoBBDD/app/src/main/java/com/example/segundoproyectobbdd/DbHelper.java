package com.example.segundoproyectobbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// CLASE PARA CREAR LA BASE DE DATOS
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";
    private static final String TABLE_CONTACTOS = "t_contactos";


    //  constructor de la clase DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

// CREAR LA BASE DE DATOS

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " + "apellido TEXT NOT NULL, " + "telefono TEXT, " + "correo TEXT, " + "email TEXT, " + " direccion Text)");

    }
    // ACTUALIZAR LA BASE DE DATOS
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(db);
    }

    // CERRAR LA BASE DE DATOS
    public void close (SQLiteDatabase db) {
        if (db != null) {
            db.close();
        }
    }

    // INSERTAR DATOS EN LA BASE DE DATOS
    public void insertar (SQLiteDatabase db, String nombre, String apellido, String telefono, String correo, String email, String direccion) {
        ContentValues cv1 = new ContentValues();
        cv1.put("nombre", nombre);
        cv1.put("apellido", apellido);
        cv1.put("telefono", telefono);
        cv1.put("correo", correo);
        cv1.put("email", email);
        cv1.put("direccion", direccion);

        db.insert(TABLE_CONTACTOS, null, cv1);

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

