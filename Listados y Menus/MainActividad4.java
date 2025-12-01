package com.example.listadosymenus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActividad4 extends AppCompatActivity {

    private Spinner spinnerPaises;
    private TextView textViewPaisSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad4_layout);

        spinnerPaises = findViewById(R.id.spinnerPaises);
        textViewPaisSeleccionado = findViewById(R.id.textViewPaisSeleccionado);

        // Lista de países
        String[] paises = {
                "España", "Francia", "Italia", "Alemania", "Portugal",
                "Grecia", "Países Bajos", "Bélgica", "Suecia", "Noruega","Naroa"
        };

        // Adaptador simple (Spinner ya trae su propio layout estándar)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                paises
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaises.setAdapter(adapter);

        // Evento de selección
        spinnerPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pais = paises[position];
                textViewPaisSeleccionado.setText("Has seleccionado: " + pais);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewPaisSeleccionado.setText("Ningún país seleccionado");
            }
        });
    }
}
