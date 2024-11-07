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

        // HTML con el iframe coladito de youtube, si añado más salen más (lol)
        String videoHtml = "<html><body style=\"margin:0;padding:0;\">" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/gZsTeBwBYoQ\" frameborder=\"1\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/AY_Ujecl2Rc\" frameborder=\"1\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/16Zq8EMCdZ4\" frameborder=\"1\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
                "<iframe width=\"100%\" height=\"240\" src=\"https://www.youtube.com/embed/h69FSgua80A\" frameborder=\"2\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +

                "</body></html>";




        // SE CARGA EL HTML SI NO ME EXPLOTA TODITO
        webView.loadData(videoHtml, "text/html", "utf-8");

        return view;
    }
}
