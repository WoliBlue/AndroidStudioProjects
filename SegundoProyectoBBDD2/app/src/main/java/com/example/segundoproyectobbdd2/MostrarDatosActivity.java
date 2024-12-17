package com.example.segundoproyectobbdd2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MostrarDatosActivity extends Activity {
    private DbHelper dbHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos); // ESTABLECER LAYOUT

        listView = findViewById(R.id.listViewDatos); // SE PILLA EL LISTVIEW

        dbHelper = new DbHelper(this); // SE INICIA EL HELPER

        // SE PILLAN LOS DATOOS DE LA BASE DE DATOS
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor consultalista = db.rawQuery("SELECT _id, nombre, apellido, telefono, email, direccion FROM " + DbHelper.TABLE_CONTACTOS, null);

        // SE MUESTRAN LAS COLUMNAS
        String[] DE = new String[] {"nombre", "apellido", "telefono", "email", "direccion"};
        // SE MUESTRAN LOS DAtOS
        int[] DESDE = new int[] {R.id.txtNombre, R.id.txtApellido, R.id.txtTelefono, R.id.txtEmail, R.id.txtDireccion};

        // EL SIMPLECURSORADAPTER VINCULA LOS DATOS AL LISTVIEW
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_dato, consultalista, DE, DESDE, 0);
        listView.setAdapter(adapter); // ESTABLECER ADAPTADOR

        // LISTENER PARA QUE TE DIGA COSITAS
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                Toast.makeText(MostrarDatosActivity.this, "Has pinchado: " + nombre, Toast.LENGTH_SHORT).show();
            }
        });

        db.close();
    }
}
