package com.example.ejemplotablas2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        num1 = findViewById(R.id.id1);
        num2 = findViewById(R.id.id2);
        num3 = findViewById(R.id.id3);
        num4 = findViewById(R.id.id4);
        num5 = findViewById(R.id.id5);
        num6 = findViewById(R.id.id6);
        num7 = findViewById(R.id.id7);
        num8 = findViewById(R.id.id8);
        num9 = findViewById(R.id.id9);
        num10 = findViewById(R.id.id10);
        resultado = findViewById(R.id.idResultado);

        String v1 = num1.getText().toString();
        String v2 = num2.getText().toString();
        String v3 = num3.getText().toString();
        String v4 = num4.getText().toString();
        String v5 = num5.getText().toString();
        String v6 = num6.getText().toString();
        String v7 = num7.getText().toString();
        String v8 = num8.getText().toString();
        String v9 = num9.getText().toString();
        String v10 = num10.getText().toString();
        String vR = resultado.getText().toString();

        int n1 = Integer.parseInt(v1);
        int n2 = Integer.parseInt(v2);
        int n3 = Integer.parseInt(v3);
        int n4 = Integer.parseInt(v4);
        int n5 = Integer.parseInt(v5);
        int n6 = Integer.parseInt(v6);
        int n7 = Integer.parseInt(v7);
        int n8 = Integer.parseInt(v8);
        int n9 = Integer.parseInt(v9);
        int n10 = Integer.parseInt(v10);
        int Resul;


        Resul = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10;
        vR = String.valueOf(Resul);
        resultado.setText(vR);


    }






}