package com.example.phpjsonconsolas;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListaAdaptador adaptador;
    private ArrayList<Consola> consolas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerConsolas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // LISTA LAYOUT
        adaptador = new ListaAdaptador(consolas); // INICIAR ADAPTADOR
        recyclerView.setAdapter(adaptador); // ADAPTADOR ABRAZA A RECYCLERVIEW

        // SE OBTIENE CONSOLAS
        obtenerDatos();
    }

    // OBTENEMOS LOS DATOS CON VOLLEY
    private void obtenerDatos() {
        String url = "http://192.168.1.132/consolas/obtenerTodasConsolas.php";
        // PEPE, SOY TU YO DEL PASADO, TIENES QUE HACER IPCONFIG Y REEMPLAZAR ESTA IP COMO TE OLVIDES EL PROFE TE SUSPENDE

        // CREAR SOLICITUD COPIA PEGA DEL PROFE
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject jsonResponse = response.getJSONObject(0);
                            if (jsonResponse.getInt("estado") == 1) {
                                JSONArray data = jsonResponse.getJSONArray("mensaje");
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject consolaJson = data.getJSONObject(i);

                                    Consola consola = new Consola(
                                            consolaJson.getString("ID"),
                                            consolaJson.getString("nombre"),
                                            consolaJson.getString("descripcion"),
                                            consolaJson.getString("anio")
                                    );
                                    consolas.add(consola);
                                }
                                adaptador.notifyDataSetChanged();
                            } else {
                                Toast.makeText(MainActivity2.this, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONError", "JSON Error: " + e.getMessage());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        String errorMessage = error.networkResponse != null ? new String(error.networkResponse.data) : error.getMessage();
                        Log.e("NetworkError", "Error: " + errorMessage, error);
                        Toast.makeText(MainActivity2.this, "Network Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
