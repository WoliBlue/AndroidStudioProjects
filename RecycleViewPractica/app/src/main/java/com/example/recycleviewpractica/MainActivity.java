package com.example.recycleviewpractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<UserModel> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView reycleViewUser = (RecyclerView) findViewById(R.id.recycleViewUser);
        //obtenemos los datos que queremos cargar
        datos=(new Datos()).getDatos();
        // use a linear layout manager (distribucion de vistas configurable)
        //como queremos que se posicionen los elementos en las vistas, como lista o como cuadricula GridLayout
        reycleViewUser.setLayoutManager(new LinearLayoutManager(this));
//puedo añadir animaciones automaticas (ItemAnimator) y sepaaciones automaticas (ItemDecoration)

        // specify an adapter with the list to show
        reycleViewUser.setAdapter(new ArticleAdapter(datos));

    }
}