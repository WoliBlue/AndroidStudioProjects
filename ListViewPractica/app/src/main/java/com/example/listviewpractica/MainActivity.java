package com.example.listviewpractica;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listado listado = new Listado();
        ArrayList<ListaEntrada> datos = listado.getDatos();

        ListView listView = findViewById(R.id.listViewConsolas);
        ListaAdaptador adaptador = new ListaAdaptador(this, R.layout.elemento_lista, datos);
        listView.setAdapter(adaptador);

        // Añadimos el listener para manejar los clicks en los elementos de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaEntrada entrada = (ListaEntrada) parent.getItemAtPosition(position);

                // Creamos un Intent para iniciar la nueva actividad
                Intent intent = new Intent(MainActivity.this, DetalleConsolaActivity.class);
                intent.putExtra("imagenId", entrada.getIdImagen());
                intent.putExtra("nombre", entrada.getTextoEncima());
                intent.putExtra("descripcion", entrada.getTextoAbajo());

                startActivity(intent);
            }
        });
    }
}
