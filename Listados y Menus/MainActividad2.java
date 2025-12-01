package com.example.listadosymenus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2_layout);

        // 1. Lista de países europeos
        String[] paises = {
                "España", "Francia", "Italia", "Alemania",
                "Portugal", "Bélgica", "Países Bajos", "Austria",
                "Suiza", "Suecia","Naroa"
        };

        // 2. Referencias a vistas
        ListView listView = findViewById(R.id.listViewPaises);
        TextView textViewSeleccion = findViewById(R.id.textViewPaisSeleccionado);

        // 3. Adaptador usando tu layout personalizado
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_paises,       // tu layout
                R.id.textViewItemPais,           // id del TextView dentro del layout
                paises
        );

        listView.setAdapter(adapter);

        // 4. Listener para detectar el país pulsado
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionado = parent.getItemAtPosition(position).toString();
                textViewSeleccion.setText("Has seleccionado: " + seleccionado);
            }
        });
    }
}

