package com.example.proyectojsonphpepefinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontrar el botón en el layout
        Button btnVerTabla = findViewById(R.id.btnVerTabla);

        // Configurar el listener para el clic del botón
        btnVerTabla.setOnClickListener(v -> {
            // Lanzar MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}