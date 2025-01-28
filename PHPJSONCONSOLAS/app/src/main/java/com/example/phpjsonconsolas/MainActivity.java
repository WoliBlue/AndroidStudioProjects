package com.example.phpjsonconsolas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerConsolas = findViewById(R.id.btnVerConsolas);
        btnVerConsolas.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
    }
}