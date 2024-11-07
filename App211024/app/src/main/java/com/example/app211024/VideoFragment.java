package com.example.app211024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos el layout del fragmento de video
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        // Encontramos el WebView en el layout
        webView = view.findViewById(R.id.webView);

        // Configurar el WebView para reproducir el video
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilitar JavaScript
        webView.setWebViewClient(new WebViewClient());

        // HTML con el iframe embebido
        String videoHtml = "<html><body style=\"margin:0;padding:0;\">" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/gZsTeBwBYoQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/AY_Ujecl2Rc\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/16Zq8EMCdZ4\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +

                "</body></html>";




        // Cargar el HTML en el WebView
        webView.loadData(videoHtml, "text/html", "utf-8");

        return view;
    }
}
