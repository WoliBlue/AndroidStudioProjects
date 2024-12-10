package com.example.primerproyectobbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Correct Button import
import android.widget.TextView; // Import TextView
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = "";
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                dbHelper.insertar(db, "PITO", "6725", "PITO@MEDAC");
                dbHelper.insertar(db, "PALA", "6575", "PALA@MEDAC");

                if (db != null) {
                    Toast.makeText(MainActivity.this, "Se ha creado la base de datos", Toast.LENGTH_SHORT).show();
                    Cursor cursor = db.rawQuery("SELECT * FROM t_contactos", null);

                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);
                        String nombre = cursor.getString(1);
                        String telefono = cursor.getString(2);
                        String correo = cursor.getString(3);

                        texto = texto + "id " + id + "; Name: " + nombre + "; Telefono: " + telefono + "; Correo: " + correo + "\n";
                    }

                    textView.setText(texto);
                    dbHelper.close();
                }
                else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}