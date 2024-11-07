package com.example.reproductor;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;


public class videoFragment extends Fragment {

    public VideoView videoView1, videoView2, videoView3, videoView4;
    public MediaController media1, media2, media3, media4;
    public WebView web,web2,web3,web4,web5;
    public videoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        web = view.findViewById(R.id.webView);
        web2 = view.findViewById(R.id.webView2);
       /*videoView1 = (VideoView) view.findViewById(R.id.videoView);
        videoView2 = (VideoView) view.findViewById(R.id.videoView2);
        videoView3 = (VideoView) view.findViewById(R.id.videoView3);
        videoView4 = (VideoView) view.findViewById(R.id.videoView4);*/
        String video1 = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/6stlCkUDG_s?si=c10yatSggdDt7ZA8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        web.loadData(video1,"text/html","utf-8");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
       /* media1 = new MediaController(getContext());
        media2 = new MediaController(getContext());
        media3 = new MediaController(getContext());
        media4 = new MediaController(getContext());
        videoView1.setMediaController(media1);
        videoView2.setMediaController(media2);
        videoView3.setMediaController(media3);
        videoView4.setMediaController(media4);*/



        // Configurar los OnClickListener para reproducir el video seleccionado
     /*   videoView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView1.start();  // Reproducir video 1
            }
        });

        videoView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView2.start();  // Reproducir video 2
            }
        });

        videoView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView3.start();  // Reproducir video 3
            }
        });

        videoView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView4.start();  // Reproducir video 4
            }
        });*/

        return view;
    }
    }
