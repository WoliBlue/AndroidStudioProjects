package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);

       /* Button Suma = findViewById(R.id.suma);
        Button Resta = findViewById(R.id.resta);
        Button Multiplicar = findViewById(R.id.multiplicar);
        Button Dividir = findViewById(R.id.dividir);*/



    }
    public void sumar(View view) {
        try {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int nro1= Integer.parseInt(valor1);
            int nro2= Integer.parseInt(valor2);
            int suma= nro1+nro2;
            tv1.setText("Resultado: " + suma);

        } catch (NumberFormatException e) {
            tv1.setText("LA HAS LIADO PARDA");
            return;
        }
    }
    public void restar(View view) {
        try {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int nro1= Integer.parseInt(valor1);
            int nro2= Integer.parseInt(valor2);
            int resta= nro1-nro2;
            tv1.setText("Resultado: " + resta);

        } catch (NumberFormatException e) {
            tv1.setText("LA HAS LIADO PARDA");
            return;
        }
    }

    public void multiplicar(View view) {
        try {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int nro1= Integer.parseInt(valor1);
            int nro2= Integer.parseInt(valor2);
            int multiplicacion= nro1*nro2;
            tv1.setText("Resultado: " + multiplicacion);

        } catch (NumberFormatException e) {
            tv1.setText("LA HAS LIADO PARDA");
            return;
        }
    }
    public void dividir(View view) {
        try {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            double nro1 = Double.parseDouble(valor1);
            double nro2 = Double.parseDouble(valor2);
            if (nro2 != 0) {
                double division = nro1 / nro2;
                tv1.setText("Resultado: " + division);
            } else {
                tv1.setText("Error: División por cero");
            }
        } catch (NumberFormatException e) {
            tv1.setText("LA HAS LIADO PARDA");
        }
    }


}