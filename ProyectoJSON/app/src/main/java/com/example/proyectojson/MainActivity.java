package com.example.proyectojson;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String CADENA = "" +
            "[{\"nombre_fruta\":\"Manzana\", " +
            "\"cantidad\":\"6\"}," +
            "{\"nombre_fruta\":\"Pera\"," +
            " \"cantidad\":\"4\"}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //creo la base de datos
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
            Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();

        }


        ArrayList<Fruta> listaFrutas = new ArrayList<>();
        // creo el JSONArray con los datos del JSON
        try {
            JSONArray array = new JSONArray(CADENA);
            // extraigo los datos del JSON
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                // creo el objeto fruta
                String nombre = object.getString("nombre_fruta");
                int unidades = object.getInt("cantidad");
                Fruta fruta = new Fruta (nombre, unidades);
                // inserto los datos en la base de datos
                listaFrutas.add(fruta);
                // añado los datos a la base de datos
                dbHelper.insertar(fruta, db);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Button btnMostrarFrutas = findViewById(R.id.btnMostrarFrutas);
        btnMostrarFrutas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MostrarFruta.class);
            startActivity(intent);
        });
    }
}