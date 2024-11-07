package com.example.minipractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText num1 = (EditText) findViewById(R.id.editText);
        EditText num2 = (EditText) findViewById(R.id.editText2);
        int c1 = Integer.parseInt(num1.getText().toString());
        int c2 = Integer.parseInt(num2.getText().toString());

        int suma = c1 + c2;

        String resultado = String.valueOf(suma);


        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, resultado);
        startActivity(intent);



        /*         try {
            int c1 = Integer.parseInt(num1.getText().toString());
            int c2 = Integer.parseInt(num2.getText().toString());

            int suma = c1 + c2;
            String resultado = String.valueOf(suma);

            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, resultado);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Handle the exception, e.g., display an error message
            Toast.makeText(this, "Invalid input. Please enter numbers.", Toast.LENGTH_SHORT).show();
        }
    }*/
    }

}