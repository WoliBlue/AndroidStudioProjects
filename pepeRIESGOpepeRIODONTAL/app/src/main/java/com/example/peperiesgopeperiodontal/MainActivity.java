package com.example.peperiesgopeperiodontal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    public EditText idEdit, nombreEdit, fechaEdit, dienteEdit, edadEdit;
    public EditText sangradoEdit, perdidaEdit, insercionEdit, diabetesEdit, tabacoEdit, profundidadEdit, porcentajeEdit;
    public TextView riesgoSangrado, riesgoAusencia, riesgoInsercion, riesgoDiabetes, riesgoTabaco, riesgoProfundidad;
    public Button sangradoButton, perdidaButton, insercionButton, diabetesButton, tabacoButton, profundidadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEdit = findViewById(R.id.idEdit);
        nombreEdit = findViewById(R.id.nombreEdit);
        fechaEdit = findViewById(R.id.fechaEdit);
        dienteEdit = findViewById(R.id.dienteEdit);
        edadEdit = findViewById(R.id.edadEdit);

        sangradoEdit = findViewById(R.id.SangradoEdit);
        perdidaEdit = findViewById(R.id.PerdidaEdit);
        insercionEdit = findViewById(R.id.InsercionEdit);
        diabetesEdit = findViewById(R.id.DiabetesEdit);
        tabacoEdit = findViewById(R.id.TacaboEdit);
        profundidadEdit = findViewById(R.id.ProfundidadEdit);
        porcentajeEdit = findViewById(R.id.PorcentajeEdit);

        riesgoSangrado = findViewById(R.id.RiesgoSangrado);
        riesgoAusencia = findViewById(R.id.RiesgoAusencia);
        riesgoInsercion = findViewById(R.id.RiesgoInsercion);
        riesgoDiabetes = findViewById(R.id.RiesgoDiabetes);
        riesgoTabaco = findViewById(R.id.RiesgoTabaco);
        riesgoProfundidad = findViewById(R.id.RiesgoProfundiad);

        sangradoButton = findViewById(R.id.Sangradobutton);
        perdidaButton = findViewById(R.id.Perdidabutton);
        insercionButton = findViewById(R.id.Insercionbutton);
        diabetesButton = findViewById(R.id.DiabetesButton);
        tabacoButton = findViewById(R.id.TabacoButton);
        profundidadButton = findViewById(R.id.ProfundidadButton);



/* lo he hecho para nada XD
        sangradoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaSangradoRiesgo();
            }
        });
*/

    }

    public void calculaSangradoRiesgo(View view) {
        try {
            String valorSangrado = sangradoEdit.getText().toString();
            int sangradoPorcentaje = Integer.parseInt(valorSangrado);

            if (sangradoPorcentaje > 25) {
                riesgoSangrado.setText("PELIGROSOSO");

            } else if (sangradoPorcentaje < 9) {

                riesgoSangrado.setText("RiesgoBajo");
            } else if (sangradoPorcentaje < 25) {

                riesgoSangrado.setText("normal");
            }


        } catch (NumberFormatException e) {
            sangradoEdit.setText("LA HAS LIADO PARDA");
            return;

        }
    }

    public void calculaPerdidaRiesgo(View view) {
        try {
            String valorPerdida = perdidaEdit.getText().toString();
            int perdidaDientes = Integer.parseInt(valorPerdida);

            if (perdidaDientes == 0) {
                riesgoAusencia.setText("No hay riesgo");
            } else if (perdidaDientes <= 4) {
                riesgoAusencia.setText("Riesgo Bajo");
            } else if (perdidaDientes <= 8) {
                riesgoAusencia.setText("Riesgo Medio");
            } else {
                riesgoAusencia.setText("Riesgo ALTISIMO.");
            }
        } catch (NumberFormatException e) {
            perdidaEdit.setText("LA HAS LIADO PARDA");
            return;


        }
    }

    public void calculaInsercionRiesgo(View view) {
        try {
            String valorInsercion = insercionEdit.getText().toString();
            int insercionDientes = Integer.parseInt(valorInsercion);
            String valorEdad = edadEdit.getText().toString();
            int edadEdit = Integer.parseInt(valorEdad);

            double insercionDientesResultado = (double) edadEdit / insercionDientes;

            if (insercionDientesResultado == 0.0) {
                riesgoInsercion.setText("No hay riesgo");
            } else if (insercionDientesResultado <= 0.5) {
                riesgoInsercion.setText("Riesgo Bajo");
            } else if (insercionDientesResultado <= 1) {
                riesgoInsercion.setText("Riesgo Altisimo");
            } else {
                riesgoInsercion.setText("Riesgo Alto de Cojones");
            }

        } catch (NumberFormatException e) {
            insercionEdit.setText("LA HAS LIADO PARDA");
            return;
        }
    }


    public void calculaDiabetesRiesgo(View view) {
        try {
            String valorDiabetes = diabetesEdit.getText().toString();
            int diabetesEdit = Integer.parseInt(valorDiabetes);

            if (diabetesEdit == 0) {
                riesgoDiabetes.setText("No tiene Diabetes");
            } else if (diabetesEdit == 1) {
                riesgoDiabetes.setText("Es diabetico.");
            }

        } catch (NumberFormatException e) {
            diabetesEdit.setText("LA HAS LIADO PARDA");
            return;
        }
    }


public void calculaTabacoRiesgo(View view) {
        try {
            String valorTabaco = tabacoEdit.getText().toString();
            int tabacoEdit = Integer.parseInt(valorTabaco);

            if (tabacoEdit == 1) {
                riesgoTabaco.setText("Es un fumetas");
                Toast.makeText(this,"FUMAR ESTÁ MAL.", Toast.LENGTH_LONG).show();
            } else if (tabacoEdit == 2) {
                riesgoTabaco.setText("No fuma.");
                Toast.makeText(this,"ENHORABUENA POR NO FUMAR", Toast.LENGTH_LONG).show();
            }
            else if (tabacoEdit == 3) {
                riesgoTabaco.setText("Ni fu ni fa.");
                Toast.makeText(this,"FUMAR ESTÁ MAL", Toast.LENGTH_LONG).show();
            }
} catch (NumberFormatException e) {
            tabacoEdit.setText("LA HAS LIADO PARDA");
            return;
        }
}
public void calculaProfundidadRiesgo(View view) {
    try {
        String valorProfundidad = profundidadEdit.getText().toString();
        int profundidadEdit = Integer.parseInt(valorProfundidad);

        if (profundidadEdit == 0) {
            riesgoProfundidad.setText("No hay riesgo");
        } else if (profundidadEdit <= 4) {
            riesgoProfundidad.setText("Riesgo Bajo");
        }
        else if (profundidadEdit <= 8) {
            riesgoProfundidad.setText("Riesgo Medio");
        }
        else  {
            riesgoProfundidad.setText("Riesgo Alto");
        }
    } catch (NumberFormatException e) {
        profundidadEdit.setText("LA HAS LIADO PARDA");
        return;
    }

}









}














