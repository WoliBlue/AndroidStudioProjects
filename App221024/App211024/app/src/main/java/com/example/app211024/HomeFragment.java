package com.example.app211024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    // HOME(R) ES EL DEFAULT DEL FRAGMENT HOME
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // ENCONTRAR EL GIF
        GifImageView gifImageView = view.findViewById(R.id.gifImageView);

        // HACER QUE EL GIF SUELTE TOAST AL PINCHAR
        gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display the Toast message
                Toast.makeText(getContext(), "hmmm servesa", Toast.LENGTH_SHORT).show();
            }
        });


        // HACER QUE EL PUTO TEXTO SE MUEVA
        TextView homerozona = view.findViewById(R.id.homerozona);
        homerozona.setSelected(true);

        TextView cositas = view.findViewById(R.id.cositas);
        cositas.setSelected(true);

        return view;
    }
}