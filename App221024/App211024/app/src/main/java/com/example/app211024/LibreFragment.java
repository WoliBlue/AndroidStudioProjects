package com.example.app211024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;


public class LibreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    // HACER QUE SE VEA
        View view = inflater.inflate(R.layout.fragment_libre, container, false);

        // RECYCLER VIEW PARA LA COLECCION DE IMAGENES
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // 2 COLUMNAS DE IMAGENES POR CUADRICULA


        // SE CREA UN ADAPTADOR PARA EL RECYCLER VIEW
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            // SE INFLA LA VISTA DE LOS ELEMENTOS DEL RECYCLER VIEW
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                // TE TRAE EL RESULTADO
                return new RecyclerView.ViewHolder(itemView) {};
            }

            @Override
            // EL BINDVIEWHOLDER ES PARA ACTUALIZAR LOS ELEMENTOS DEL RECYCLER VIEW
            // PRIMERO PILLA LA REFERENCIA A LAS IMAGE VIEW, EL GETITEMCOUNT PILLA EL GET IMAGES
            // QUE TIENEN EL ARRAY DE IMAGENES DE ABAJO DEL TODITO TODISIMO
            //
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ImageView imageView = holder.itemView.findViewById(R.id.image_view);
                imageView.setImageResource(getImages().get(position));
            }

            @Override
            public int getItemCount() {
                return getImages().size();
            }
        };

        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Integer> getImages() {

        return Arrays.asList(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6,
                R.drawable.image7,  R.drawable.caballo);
    }
}
