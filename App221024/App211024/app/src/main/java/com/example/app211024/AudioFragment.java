package com.example.app211024;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AudioFragment extends Fragment {
    private MediaPlayer mediaPlayer;
        // se crea el media player pa audio
        private ImageView imageView;
     private int[] canciones = {R.raw.mi_audio, R.raw.mi_audio2, R.raw.mi_audio3}; // MISC, CZARFACE Y DOOM
    private int[] imagenes = {R.drawable.miscportada, R.drawable.doomportada, R.drawable.foodportada}; // MISC, CZARFACE Y DOOM
    private int currentSongIndex = 0; // La primera cancion es mi_audio por su posicion 0
    private String[] titulos = {"The Lightning Thief - Misc", "VomitSpit - MFDOOM", "Mando Calrissian - Czarface"}; // LOS TITULOS PAL TEXTO


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // SE INFLA ( SE PONE LA PESTAÑA)
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        imageView = view.findViewById(R.id.imageView); // pillamos el imageview

        TextView NowPlaying = view.findViewById(R.id.NowPlaying);
        NowPlaying.setSelected(true);  // LO MISMO QUE EL TEXTO DE HOMER


        // SE CREAN LOS BOTONES
        Button playButton = view.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirAudio();
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

        Button previousSongButton = view.findViewById(R.id.previousSongButton);
        previousSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnteriorCancion(v);
            }
        });

        Button nextSongButton = view.findViewById(R.id.nextSongButton);
        nextSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SiguienteCancion(v);
            }
        });




        return view;
    }




    // AQUI SON LOS VOIDS PA QUE FUNCIONEN
    public void reproducirAudio() {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(getContext(), canciones[currentSongIndex]); // Usa la cancion actual
                if (mediaPlayer == null) {
                    Toast.makeText(getContext(), "Error al cargar el archivo de audio", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else {
                mediaPlayer.reset(); // resetea
                mediaPlayer.setDataSource(getResources().openRawResourceFd(canciones[currentSongIndex]));
                mediaPlayer.prepare();
            }

            mediaPlayer.start();
            imageView.setImageResource(imagenes[currentSongIndex]); // SE ACTUALIZA IMAGEN

            // SE ACTUALIZA EL TEXTO DE CANCION ACTUAL
            TextView nowPlayingTextView = requireView().findViewById(R.id.NowPlaying);
            nowPlayingTextView.setText("NOW PLAYING - " + titulos[currentSongIndex] + "||| NOW PLAYING - " + titulos[currentSongIndex] );
            nowPlayingTextView.setSelected(true);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al reproducir el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void pausarAudio(View view) {
        try {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                // SI HAY ALGO SONANDO Y ESTA SONANDO AHORA PUES SE PARA
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
                // SI HAY ALGO ESTABA SONANDO Y SE HA PAUSADO, AHORA SE REANUDA
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
                // SI HAY ALGO SONANDO AHORA SE DETIENE COMPLETAMENTE
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
                // SE VA AL SEGUNDO CERO SI ESTÁ SONANDO PARA EMPEZAR DE NUEVO
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al reiniciar el audio", Toast.LENGTH_SHORT).show();
        }
    }

    public void avanzarAudio(View view) {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            // SE PILLA EN QUE SEGUNDO ESTÁ SONANDO Y SE LE AÑADEN LOS DE ABAJO
            int ParaAlante = 10000; // 10 SEGUNDOS
            if ((currentPosition + ParaAlante) <= mediaPlayer.getDuration()) {
                mediaPlayer.seekTo(currentPosition + ParaAlante);
                // SI SE PUEDE AVANZAR SE HACE, Y SE SUMA EL TIEMPO DE AVANCE AL ACTUAL
            }
        }
    }

    public void retrocederAudio(View view) {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int ParaAtras = 10000; // 10 SEGUNDOS
            if ((currentPosition - ParaAtras) >= 0) {
                mediaPlayer.seekTo(currentPosition - ParaAtras);
                // LO MISMO PERO MARCHA ATRAS TAMPOCO ES MUCHO
            }
        }
    }

    public void silenciarAudio(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0, 0);
            // SE CALLA TODISIMO PARA SILENCIAR
        }
    }

    public void reactivarAudio(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1, 1);
            // VUELVE EL SONIDO NORMAL
        }
    }
    public void AnteriorCancion(View view) {
        currentSongIndex = (currentSongIndex - 1 + canciones.length) % canciones.length;
        reproducirAudio();
        imageView.setImageResource(imagenes[currentSongIndex]); // CAMBIA LA POSICION DE IMAGEN CON LA POSICION DE CANCION
    }

    public void SiguienteCancion(View view) {
        currentSongIndex = (currentSongIndex + 1) % canciones.length;
        reproducirAudio();
        imageView.setImageResource(imagenes[currentSongIndex]); // CAMBIA LA POSICION DE IMAGEN CON LA POSICION DE CANCION
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            // SE LIBERA LA MEMORIA PARA QUE NO PETE
        }
    }



}
