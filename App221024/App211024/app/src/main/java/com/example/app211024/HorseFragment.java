package com.example.app211024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;


public class HorseFragment extends Fragment {

    @Nullable
    @Override
    // LO COPIA PEGUÉ TODISIMO DEL PROYECTO DONDE USÉ LO DEL CABALLO
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horse, container, false);

        LinearLayout mainLayout = view.findViewById(R.id.mainLayout);
        TextView textViewInsideLayout = mainLayout.findViewById(R.id.textLayout1);

        ImageView caballin = view.findViewById(R.id.caballin);
        Button detonador = view.findViewById(R.id.detonador);

        detonador.setOnClickListener(new View.OnClickListener() {
            @Override
            // es muy simple, al pulsar la imagen se cambia por otra y se cambia el texto tambien y se desactiva el boton, no es pa tanto
            public void onClick(View v) {
                caballin.setImageResource(R.drawable.image6);
                textViewInsideLayout.setText("GRACIAS COLEGA -Ayuso");
                detonador.setEnabled(false);
            }
        });

        return view;
    }
}