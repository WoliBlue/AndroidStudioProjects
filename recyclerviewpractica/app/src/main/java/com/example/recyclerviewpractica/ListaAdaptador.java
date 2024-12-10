package com.example.recyclerviewpractica;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.view.animation.AnimationUtils;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.ViewHolder> {

    // SE DECLARA LISTENER Y LA LISTA
    private ArrayList<ListaNintendo> listaNintendos;
    private OnItemClickListener listener;

    // LA INTERFAZ PARA CLICKAR COSILLAS
    public interface OnItemClickListener {
        void onItemClick(ListaNintendo item);
    }

    // SE CONSTRUYE EL ADAPTADOR CON LA LISTA Y EL LISTENER
    public ListaAdaptador(ArrayList<ListaNintendo> listaNintendos, OnItemClickListener listener) {
        this.listaNintendos = listaNintendos;
        this.listener = listener;
    }

    // METODO PARA CREAR UNA NUEVA VISTA CON EL LAYOUT MANAGER
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // SE INFLA EL LAYOUT DEL ITEM Y SE CREA EL VIEWHOLDER
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista, parent, false);
        return new ViewHolder(view);
    }

    // REEMPLAZAR EL CONTENIDO DE LA VISTA (LLAMADO POR EL LAYOUT MANAGER)
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        // Obtener el ítem de datos de la posición actual
        ListaNintendo entrada = listaNintendos.get(position);
        // Reemplazar el contenido de la vista con esos datos
        holder.asignarDatos(entrada, listener);
    }

    // PARA OBTENER TODOS LOS ELEMENTOS DE LA LISTA
    @Override
    public int getItemCount() {
        // DEVUELVE TODITO SANO Y SALVO :D
        return listaNintendos.size();
    }

    // VIEWHOLDER QUE ASOCIA LAS VISTAS DE UN ITEM CON LOS DATOS
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView textoEncima;
        private TextView textoAbajo;

        // CONSTRUCTOR DE LA CLASE VIEWHOLDER
        public ViewHolder(View itemView) {
            super(itemView);
            // Asignar las vistas a las variables
            imagen = itemView.findViewById(R.id.imagenConsola);
            textoEncima = itemView.findViewById(R.id.nombreConsola);
            textoAbajo = itemView.findViewById(R.id.detalleConsola);
        }

        // METODO PARA ASIGNAR LOS DATOS A LAS VISTAS DE UN ITEM DEL RECYCLER VIEW
        public void asignarDatos(final ListaNintendo item, final OnItemClickListener listener) {
            // ASIGNAMOS LAS COSAS
            imagen.setImageResource(item.getIdImagen());
            textoEncima.setText(item.getTextoEncima());
            textoAbajo.setText(item.getTextoAbajo());
            // LISTENER DEL CLICK
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                    Toast.makeText(v.getContext(), "Nombre de la consola: " + item.getTextoEncima(), Toast.LENGTH_SHORT).show();
                    // SE PONE LA ANIMACION
                    Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.rotate_in_animation);
                    v.startAnimation(animation);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // CLICK PROLOGANDO
                    Toast.makeText(v.getContext(),"SABES COMO MANTENER PULSADO",Toast.LENGTH_LONG).show();
                    MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.monedita);
                    mediaPlayer.start();
                    return true;
                }
            });
        }
    }
}
