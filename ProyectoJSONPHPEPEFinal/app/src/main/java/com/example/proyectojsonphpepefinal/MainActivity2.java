package com.example.proyectojsonphpepefinal;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    // Componentes de la interfaz de usuario
    private RecyclerView recyclerView;
    private ConsolaAdapter adapter;

    // Componentes de red
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear un adaptador vacío y asignarlo al RecyclerView
        adapter = new ConsolaAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Inicializar la cola de solicitudes de Volley
        requestQueue = Volley.newRequestQueue(this);

        // Obtener los datos de la API
        fetchConsolas();
    }

    private void fetchConsolas() {
        // URL de la API
        String url = "http://10.0.2.2/consolas/obtenerTodasConsolas.php";

        // Crear una solicitud JSON
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    Log.d("API_RESPONSE", response.toString()); // Registrar la respuesta de la API
                    handleResponse(response);
                },
                error -> {
                    Log.e("API_ERROR", error.toString()); // Registrar errores
                    error.printStackTrace();
                }
        );

        // Añadir la solicitud a la cola
        requestQueue.add(jsonArrayRequest);
    }

    private void handleResponse(JSONArray response) {
        try {
            // Analizar la estructura JSON anidada
            JSONArray data = response.getJSONObject(0).getJSONArray("mensaje");

            // Convertir JSON a objetos Java usando Gson
            Gson gson = new Gson();
            List<Consola> consolas = gson.fromJson(
                    data.toString(),
                    new TypeToken<List<Consola>>(){}.getType()
            );

            // Actualizar el adaptador con los nuevos datos
            adapter = new ConsolaAdapter(consolas);
            recyclerView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}