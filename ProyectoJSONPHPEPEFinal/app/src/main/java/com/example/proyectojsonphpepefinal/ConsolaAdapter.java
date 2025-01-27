package com.example.proyectojsonphpepefinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConsolaAdapter extends RecyclerView.Adapter<ConsolaAdapter.ConsolaViewHolder> {

    // Lista para almacenar los datos de las consolas
    private List<Consola> consolas;

    // Constructor
    public ConsolaAdapter(List<Consola> consolas) {
        this.consolas = consolas;
    }

    // Crea nuevas vistas (invocado por el administrador de diseño)
    @NonNull
    @Override
    public ConsolaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento de la lista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_consola, parent, false);
        return new ConsolaViewHolder(view);
    }

    // Reemplaza el contenido de una vista (invocado por el administrador de diseño)
    @Override
    public void onBindViewHolder(@NonNull ConsolaViewHolder holder, int position) {
        // Obtener la consola actual
        Consola consola = consolas.get(position);

        // Vincular los datos a las vistas
        holder.txtNombre.setText(consola.getNombre());
        holder.txtAnio.setText("Lanzamiento: " + consola.getAnio());
        holder.txtDescripcion.setText(consola.getDescripcion());
    }

    // Devuelve el tamaño del conjunto de datos (invocado por el administrador de diseño)
    @Override
    public int getItemCount() {
        return consolas.size();
    }

    // Clase ViewHolder que proporciona referencias a las vistas para cada elemento de datos
    public static class ConsolaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtAnio, txtDescripcion;

        public ConsolaViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializar las vistas
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtAnio = itemView.findViewById(R.id.txtAnio);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}