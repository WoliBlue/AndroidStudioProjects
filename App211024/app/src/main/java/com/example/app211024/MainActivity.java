package com.example.app211024;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración del ViewPager2 que manejará la navegación entre pestañas
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new MiPageAdapter(this));

        // Configuración del TabLayout que muestra las pestañas
        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Configuración de los nombres de las pestañas según la posición
                switch (position) {
                    case 0:
                        tab.setText("HOME");
                        break;
                    case 1:
                        tab.setText("AUDIO");
                        break;
                    case 2:
                        tab.setText("VIDEO");
                        break;
                    case 3:
                        tab.setText("OTRO");
                        break;
                }
            }
        }).attach(); // Conexión del TabLayout con el ViewPager2
    }
}
