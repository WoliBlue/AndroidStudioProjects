package com.example.app211024;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiPageAdapter extends FragmentStateAdapter {
    public MiPageAdapter(MainActivity activity) {
        super(activity);
    }

    // Este método crea el fragmento adecuado según la posición de la pestaña
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment(); // Fragmento para la pestaña HOME
            case 1:
                return new AudioFragment(); // Fragmento para la pestaña AUDIO
            case 2:
                return new VideoFragment(); // Fragmento para la pestaña VIDEO
            case 3:
                return new LibreFragment(); // Fragmento para la pestaña LIBRE
        }
        return null;
    }

    // Este método devuelve la cantidad de pestañas
    @Override
    public int getItemCount() {
        return 4;
    }
}
/*
Funcionalidad de MiPageAdapter
Constructor: El constructor recibe la actividad principal (MainActivity) como contexto.

createFragment: Este método crea una instancia del
 fragmento correcto para cada pestaña según su posición. Por ejemplo,
  si la posición es 0, se creará HomeFragment; si la posición es 1, AudioFragment;
  y así sucesivamente.

getItemCount: Este método devuelve el número total de pestañas, en este caso, 4.

Básicamente, MiPageAdapter permite que el ViewPager2 muestre los diferentes
fragmentos y sepa cuál mostrar en cada momento.


 */