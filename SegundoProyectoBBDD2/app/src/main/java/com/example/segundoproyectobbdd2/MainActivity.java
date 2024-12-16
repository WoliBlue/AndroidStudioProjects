package com.example.segundoproyectobbdd2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText txtNombre, txtApellido, txtTelefono, txtEmail, txtDireccion;
    private Button btnInsertar, btnMostrar;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SE INICIALIZA TODDO EL LAYOUT
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnMostrar = findViewById(R.id.btnMostrar);

        // TAMBIEN SE CREA EL HELPER PARA LA BASE DE DATOS
        dbHelper = new DbHelper(this);

        // SE CONFIGURA EL BOTON DE INSERTAR
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String email = txtEmail.getText().toString();
                String direccion = txtDireccion.getText().toString();

                // LA INSERTACIÓN EN SÍ
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.insertar(db, nombre, apellido, telefono, email, direccion);
                db.close();

                // SE LIMPIA EL TEXTO
                txtNombre.setText("");
                txtApellido.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");
                txtDireccion.setText("");
            }
        });

        // EL BOTON DE MOSRAR
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SE CREA EL INTENT
                Intent intent = new Intent(MainActivity.this, MostrarDatosActivity.class);
                startActivity(intent);
            }
        });
    }
}
