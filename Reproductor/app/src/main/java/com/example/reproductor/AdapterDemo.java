package com.example.reproductor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterDemo extends FragmentStateAdapter {
    public AdapterDemo(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new homeFragment();
          case 1:
              return new videoFragment();
            default:
                return new homeFragment();
        }

    }

    @Override
    public int getItemCount() {

        return 2; // de momento porque no tengo terminado videoFragment
    }
}
