package com.example.phpjsonconsolas;


import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.ViewHolder> {
    private ArrayList<Consola> consolas;

    public ListaAdaptador(ArrayList<Consola> consolas) {
        this.consolas = consolas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout de cada ítem de la lista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Consola consola = consolas.get(position); // PILLAR CONSOLA
        holder.tvNombre.setText(consola.getNombre()); // PONER NOMBRE
        holder.tvDescripcion.setText(consola.getDescripcion()); // PONER DESC
        holder.tvAnio.setText("Año: " + consola.getAnio()); // PONER AÑO
    }

    @Override
    public int getItemCount() {
        return consolas.size();
    }

    // VIEWHOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion, tvAnio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvAnio = itemView.findViewById(R.id.tvAnio);
        }
    }
}