package com.example.recyclerviewpractica;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SE COGE EL RECYCLER VIEW
        RecyclerView recyclerView = findViewById(R.id.recyclerViewConsolas);

        // SE CAMBIA A GRIDLAYOUT CON LA COLUMNA QUE QUIERA
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // CREO EL LISTADO Y PILLO DATOS
        Listado listado = new Listado();
        ArrayList<ListaNintendo> datos = listado.getDatos();

        // SE CREA EL ADAPTADOR
        adaptador = new ListaAdaptador(datos, new ListaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(ListaNintendo item) {
                // INTENT PARA LOS DETALLES
                Intent intent = new Intent(MainActivity.this, DetalleConsolaActivity.class);
                // SE PASA EL INTENT CON LOS DATOS
                intent.putExtra("imagenId", item.getIdImagen());
                intent.putExtra("nombre", item.getTextoEncima());
                intent.putExtra("descripcion", item.getTextoAbajo());

                // SE INICIA EL INTENT COMO ACTIVIDAD
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adaptador); // EL ADAPTADOR SE VUELVE RECYCLER

        // ANIMACION DEL RECYCLER VIEW
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.scheduleLayoutAnimation();
    }
}