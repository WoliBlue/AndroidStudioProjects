package com.example.listviewpractica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaAdaptador extends BaseAdapter {
    private Context contexto;
    private int idLayoutVista;
    private ArrayList<ListaNintendo> listaNintendos;

    public ListaAdaptador(Context contexto, int idLayoutVista, ArrayList<ListaNintendo> listanintendo) {
        this.contexto = contexto;
        this.idLayoutVista = idLayoutVista;
        this.listaNintendos = listanintendo;
    }

    @Override
    public int getCount() {
        return listaNintendos.size(); // DEVUELVE CUANTAS COSAS HAY EN NINTENDOP
    }

    @Override
    public Object getItem(int posicion) {
        return listaNintendos.get(posicion); // DEVUELVE LA POSICION
    }


    @Override
    public long getItemId(int posicion) {
        return posicion; // DEVUELVE ID
    }


    @Override
    public View getView(int posicion, View vista, ViewGroup pariente) {
        if (vista == null) {
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflador.inflate(idLayoutVista, pariente, false); //  INFLADO ROBADO DE LA ANTERIOR PRACTICA
        }

        ListaNintendo entrada = (ListaNintendo) getItem(posicion); // COGE LA POSICION DE LA LISTA NINTENDO

        // LE DA VALOR A LOS ELEMENTOS DEL ARRAY
        ImageView imagen = (ImageView) vista.findViewById(R.id.imagenConsola);
        TextView textoEncima = (TextView) vista.findViewById(R.id.nombreConsola);
        TextView textoAbajo = (TextView) vista.findViewById(R.id.detalleConsola);

        imagen.setImageResource(entrada.getIdImagen());
        textoEncima.setText(entrada.getTextoEncima());
        textoAbajo.setText(entrada.getTextoAbajo());

        return vista; // DEVUELVE TODILLO O NO FUNCIONA
    }
}
