package com.example.recyclerviewpractica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



import android.widget.TextView;

public class DetalleConsolaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_consola);

        // COGEMOS LA INFO DE LA LISTA
        Intent intent = getIntent();
        int imagenId = intent.getIntExtra("imagenId", 0);
        String nombre = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");

        // IMAGEN, TEXTO, TEXTO DESCRIPCION Y EL BOTON
        ImageView imagenConsola = findViewById(R.id.detalleImagenConsola);
        TextView nombreConsola = findViewById(R.id.detalleNombreConsola);
        TextView descripcionConsola = findViewById(R.id.detalleDescripcionConsola);
        Button botonVolver = findViewById(R.id.botonVolver);

        // PONEMOS LOS DATOS
        imagenConsola.setImageResource(imagenId);
        nombreConsola.setText(nombre);
        descripcionConsola.setText(descripcion);

        // BOTON POR SI EL MOVIL ES UNA MIERDA Y NO TIENE LOS 3 BOTONES
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.rotate_in_animation2);
                v.startAnimation(animation);
            }
        });
    }
}
