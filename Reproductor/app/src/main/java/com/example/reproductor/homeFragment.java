package com.example.reproductor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class homeFragment extends Fragment {

    private Button btnTupac;



    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated (@NonNull  View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        btnTupac = (Button) view.findViewById(R.id.btn_tupac);
         // Añadir listeners si necesitas que estos botones realicen alguna acción
        btnTupac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón btn_tupac
            }
        });

    }
}