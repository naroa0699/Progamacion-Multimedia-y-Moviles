package com.example.listadosymenus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActividad3 extends AppCompatActivity {

    private GridView gridViewPaises;
    private TextView textViewPaisSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad3_layout);

        gridViewPaises = findViewById(R.id.gridViewPaises);
        textViewPaisSeleccionado = findViewById(R.id.textViewPaisSeleccionado);

        // Lista de países
        String[] paises = {
                "España", "Francia", "Italia", "Alemania", "Portugal",
                "Grecia", "Países Bajos", "Bélgica", "Suecia", "Noruega","Naroa"
        };

        // Adaptador usando list_item_paises.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_paises,
                R.id.textViewItemPais,
                paises
        );

        gridViewPaises.setAdapter(adapter);

        // Evento clic en cada elemento
        gridViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paisSeleccionado = paises[position];
                textViewPaisSeleccionado.setText("Has seleccionado: " + paisSeleccionado);
            }
        });
    }
}

