package com.example.app211024;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AudioFragment extends Fragment {
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        Button playButton = view.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirAudio(v);
            }
        });

        Button pauseButton = view.findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarAudio(v);
            }
        });

        Button resumeButton = view.findViewById(R.id.resumeButton);
        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reanudarAudio(v);
            }
        });

        Button stopButton = view.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerAudio(v);
            }
        });

        Button restartButton = view.findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarAudio(v);
            }
        });

        Button seekForwardButton = view.findViewById(R.id.seekForwardButton);
        seekForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avanzarAudio(v);
            }
        });

        Button seekBackwardButton = view.findViewById(R.id.seekBackwardButton);
        seekBackwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrocederAudio(v);
            }
        });

        Button muteButton = view.findViewById(R.id.muteButton);
        muteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                silenciarAudio(v);
            }
        });

        Button unmuteButton = view.findViewById(R.id.unmuteButton);
        unmuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reactivarAudio(v);
            }
        });

        return view;
    }

    public void reproducirAudio(View view) {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.mi_audio);
                if (mediaPlayer == null) {
                    Toast.makeText(getContext(), "Error al cargar el archivo de audio", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al reproducir el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void pausarAudio(View view) {
        try {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al pausar el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void reanudarAudio(View view) {
        try {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al reanudar el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void detenerAudio(View view) {
        try {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.prepare();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al detener el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void reiniciarAudio(View view) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al reiniciar el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void avanzarAudio(View view) {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int forwardTime = 10000; // 10 seconds
            if ((currentPosition + forwardTime) <= mediaPlayer.getDuration()) {
                mediaPlayer.seekTo(currentPosition + forwardTime);
            }
        }
    }

    public void retrocederAudio(View view) {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int backwardTime = 10000; // 10 seconds
            if ((currentPosition - backwardTime) >= 0) {
                mediaPlayer.seekTo(currentPosition - backwardTime);
            }
        }
    }

    public void silenciarAudio(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0, 0);
        }
    }

    public void reactivarAudio(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1, 1);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
