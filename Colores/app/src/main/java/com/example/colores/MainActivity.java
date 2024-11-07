package com.example.colores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    Switch miSwitch = findViewById(R.id.switch1);
    Button miButton = findViewById(R.id.button);
    Button miButton2 = findViewById(R.id.button2);
    Button miButton3 = findViewById(R.id.button1);
    Button miButton4= findViewById(R.id.granboton);

        TextView saludo = findViewById(R.id.saludo1);
        TextView saludo1 = findViewById(R.id.saludo2);
        TextView saludo2 = findViewById(R.id.saludo3);
        TextView saludo3 = findViewById(R.id.saludo4);
        TextView saludo4 = findViewById(R.id.saludo5);



        miButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo1.animate().alpha(0.0f).setDuration(500);
            }
        });
        miButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo.animate().alpha(0.0f).setDuration(500);
            }
        });
        miButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo2.animate().alpha(0.0f).setDuration(500);
                saludo3.animate().alpha(0.0f).setDuration(500);
                saludo4.animate().alpha(0.0f).setDuration(500);
            }
        });
        miButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo.animate().alpha(1.0f).setDuration(500);
                saludo1.animate().alpha(1.0f).setDuration(500);
                saludo2.animate().alpha(1.0f).setDuration(500);
                saludo3.animate().alpha(1.0f).setDuration(500);
                saludo4.animate().alpha(1.0f).setDuration(500);
            }
        });


    }
}