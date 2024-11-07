package com.example.reproductor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TabItem music;
    private TabItem video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);  // Inicializa el ViewPager2
        AdapterDemo adapterDemo = new AdapterDemo(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(adapterDemo);
        music = (TabItem) findViewById(R.id.music);
        video = (TabItem) findViewById(R.id.video);
        //  ESTO HACE QUE SALGAN LAS ETIQUEDAS DE MUSIC Y VIDEO EN SUS POSICIONES
        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("MUSIC"); // Texto para la primera pestaña
                        break;
                    case 1:
                        tab.setText("VIDEO"); // Texto para la segunda pestaña
                        break;
                }
            }
        }).attach();

    }
}
