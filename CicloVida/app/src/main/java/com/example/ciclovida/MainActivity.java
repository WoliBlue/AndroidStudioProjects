package com.example.ciclovida;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   EdgeToEdge.enable(this);
       /* setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        */
        Toast.makeText(this,"actividad creadaa", Toast.LENGTH_LONG).show();

    }

   // protected void onDestroy(Bundle savedInstanceState) {
     //   super onDestroy();
      //  Toast.makeText(this,"actividad destruidaa", Toast.LENGTH_LONG).show();
   // }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"actividad RESTARTEADA", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"actividad EMPEZADAA", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"actividad PARADAA", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"actividad DESTRUIDAA", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this,"actividad RESUMIDA", Toast.LENGTH_LONG).show();
    }
}