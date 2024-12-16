package com.example.segundoproyectobbdd2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2; // ESTA PUESTO EN 2 PORQUE EN 1 NO VA
    private static final String DATABASE_NAME = "agenda.db";
    public static final String TABLE_CONTACTOS = "t_contactos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // CREAR BASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "apellido TEXT NOT NULL, " +
                "telefono TEXT, " +
                "email TEXT, " +
                "direccion TEXT)");
    }

    // ACTUALIZAR BASE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(db);
    }

    // CERRAR BASE
    public void close(SQLiteDatabase db) {
        if (db != null) {
            db.close();
        }
    }

    // INSERTAR A BASE DE DATOS
    public void insertar(SQLiteDatabase db, String nombre, String apellido, String telefono, String email,
                         String direccion) {
        ContentValues cv1 = new ContentValues();
        cv1.put("nombre", nombre);
        cv1.put("apellido", apellido);
        cv1.put("telefono", telefono);
        cv1.put("email", email);
        cv1.put("direccion", direccion);

        db.insert(TABLE_CONTACTOS, null, cv1);
    }
}
