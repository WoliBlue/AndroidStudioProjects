package com.example.app211024;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiPageAdapter extends FragmentStateAdapter {
    public MiPageAdapter(MainActivity activity) {
        super(activity);
    }

    // ESTE METODO CREA EL FRAGMENTO (FRAGMENT) SEGUN LA PESTAÑA
    // ESTO ES PARA QUE EL VIEWPAGER 2 HAGA ALGO, QUE SEPA LO QUE HACER, OTRO PUTO SWITCH
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // EL CREATE FRAGMENT CREA EL FRAGMENTO CORRECTO SEGUN LA PESTAÑA, EN 0 ES HOME
        switch (position) {
            case 0:
                return new HomeFragment(); // Fragmento para la pestaña HOME
            case 1:
                return new AudioFragment(); // Fragmento para la pestaña AUDIO
            case 2:
                return new VideoFragment(); // Fragmento para la pestaña VIDEO
            case 3:
                return new LibreFragment(); // Fragmento para la pestaña LIBRE
            case 4:
                return new HorseFragment(); // Fragmento para la pestaña caballo
        }
        return null;
    }

    // DEVOLVER PESTAÑAS
    @Override
    public int getItemCount() {
        // DEVUELVE EL NUMERO DE PESTAÑAS QUE HAY, SI AÑADO UNA NUEVA, SERIA UN CASE 5 PERO AQUI ES RETURN 6 POR EL 0
        return 5;
    }
}

