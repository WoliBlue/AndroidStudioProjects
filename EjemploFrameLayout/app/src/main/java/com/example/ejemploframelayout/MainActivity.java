package com.example.ejemploframelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public TextView et1, et2, et3, et4;
    public ImageView imageView;
    public Button button;
    public boolean CaballoVivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        // Initialize EditTexts
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CaballoVivo) {
                    imageView.setImageResource(R.drawable.grave);
                   // setvisible(View.INVISIBLE);
                //   et1.setVisibility(View.INVISIBLE);
                    CaballoVivo = false;
                    et1.setText("Caballo muerto");
                    et2.setText("Caballo muerto");
                    et3.setText("Caballo muerto");
                    et4.setVisibility(View.INVISIBLE);
                    button.setText("REVIVIR");
                } else {
                    imageView.setImageResource(R.drawable.caballo);
                    CaballoVivo = true;
                    et1.setText("Lo has revivido!");
                    et2.setText("Eureka!");
                    et3.setText("Eres un heroe!");
                    et4.setVisibility(View.VISIBLE);
                    button.setText("MATAR DE NUEVO");

                }
            }
        });
    }
}