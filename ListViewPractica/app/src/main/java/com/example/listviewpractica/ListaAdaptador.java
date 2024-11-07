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
    private ArrayList<ListaEntrada> entradas;

    public ListaAdaptador(Context contexto, int idLayoutVista, ArrayList<ListaEntrada> entradas) {
        this.contexto = contexto;
        this.idLayoutVista = idLayoutVista;
        this.entradas = entradas;
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entradas.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup pariente) {
        if (vista == null) {
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflador.inflate(idLayoutVista, pariente, false);
        }

        ListaEntrada entrada = (ListaEntrada) getItem(posicion);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imagenConsola);
        TextView textoEncima = (TextView) vista.findViewById(R.id.nombreConsola);
        TextView textoAbajo = (TextView) vista.findViewById(R.id.detalleConsola);

        imagen.setImageResource(entrada.getIdImagen());
        textoEncima.setText(entrada.getTextoEncima());
        textoAbajo.setText(entrada.getTextoAbajo());

        return vista;
    }
}
