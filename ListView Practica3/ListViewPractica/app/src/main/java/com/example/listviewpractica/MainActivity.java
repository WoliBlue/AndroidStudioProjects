package com.example.listviewpractica;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.net.Uri;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CREO EL LISTADO Y PILLO DATOS
        Listado listado = new Listado();
        ArrayList<ListaNintendo> datos = listado.getDatos();


        ListView listView = findViewById(R.id.listViewConsolas);
        // SE CREA EL ADAPTADOR Y SE LO PASA AL LISTVIEW PARA QUE MUESTRE LOS DATOS
        ListaAdaptador adaptador = new ListaAdaptador(this, R.layout.elemento_lista, datos);
        // PONEMOS EL ADAPTADOR EN EL LISTVIEW
        listView.setAdapter(adaptador);

        // LISTENER PARA LOS CLICKS
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // SE OBTIENE LA LISTA DE NINTENDO
                ListaNintendo listanintendo = (ListaNintendo) parent.getItemAtPosition(position);

                // INTENT PARA LOS DETALLES
                Intent intent = new Intent(MainActivity.this, DetalleConsolaActivity.class);
                // SE PASA EL INTENT CON LOS DATOS
                intent.putExtra("imagenId", listanintendo.getIdImagen());
                intent.putExtra("nombre", listanintendo.getTextoEncima());
                intent.putExtra("descripcion", listanintendo.getTextoAbajo());

                // SE INICIA EL INTENT COMO ACTIVIDAD
                startActivity(intent);
            }
        });

            //BOTON DE GOOGLE MAPS
        Button btnKFCMarbella = findViewById(R.id.btnKFCMarbella);
        btnKFCMarbella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=101+kfc+la+cañada");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                 mapIntent.setPackage("com.google.android.apps.maps");
                 startActivity(mapIntent);

            }
        });
        //BOTON DE LLAMAR AL Pepe
        Button btnLlamaAlPepe = findViewById(R.id.btnLlamaAlPepe);
        btnLlamaAlPepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamarintent = new Intent(Intent.ACTION_DIAL);
                llamarintent.setData(Uri.parse("tel:32531345"));
                startActivity(llamarintent);
            }
        });
        //BOTON DE VE A YOUTUBE
        Button btnVeAYoutube = findViewById(R.id.btnVeAYoutube);
        btnVeAYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ytintent = new Intent(Intent.ACTION_VIEW);
                ytintent.setData(Uri.parse("https://www.youtube.com/watch?v=_JUpTOFJUTU/"));
                startActivity(ytintent);
            }
        });

    }
}
