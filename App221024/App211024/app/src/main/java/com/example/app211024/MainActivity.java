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

        // VIEJA PAJER 2
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new MiPageAdapter(this));

        // CREO EL SWITCH DE TABS Y LUEGO EN MIPAGEADAPTER
        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.icon_home);
                        tab.setText("HOME"); //
                        break;
                    case 1:
                        tab.setIcon(R.drawable.icon_audio);
                        tab.setText("AUDIO");
                        break;
                    case 2:
                        tab.setIcon(R.drawable.icon_video);
                        tab.setText("VIDEO");
                        break;
                    case 3:
                        tab.setIcon(R.drawable.icon_libre);
                        tab.setText("LIBRE");
                        break;
                    case 4:
                        tab.setIcon(R.drawable.horse);
                        tab.setText("HORSE");
                        break;
                }
            }
        }).attach();
    }
}
