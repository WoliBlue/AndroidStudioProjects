package com.example.proyectojson;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MostrarFruta extends AppCompatActivity {

    private ListView listViewFrutas;
    private ArrayList<String> listaInformacion;
    private ArrayList<Fruta> listaFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_fruta);

        listViewFrutas = findViewById(R.id.listViewFrutas);
        listaFrutas = new ArrayList<>();
        listaInformacion = new ArrayList<>();

        // Obtener las frutas de la base de datos
        consultarListaFrutas();

        // Crear un adaptador para mostrar la información en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaInformacion);
        listViewFrutas.setAdapter(adapter);
    }

    private void consultarListaFrutas() {
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Fruta fruta = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_FRUTAS, null);

        while (cursor.moveToNext()) {
            fruta = new Fruta(
                    cursor.getString(1),
                    cursor.getInt(2)
            );
            listaFrutas.add(fruta);
            listaInformacion.add("Nombre: " + fruta.getNombre() + " - Cantidad: " + fruta.getUnidades());
        }

        cursor.close();

        if (listaFrutas.isEmpty()) {
            Toast.makeText(this, "No hay frutas en la base de datos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Se han cargado las frutas", Toast.LENGTH_SHORT).show();
        }
    }
}