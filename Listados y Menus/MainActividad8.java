package com.example.listadosymenus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadosymenus.adapters.VersionAdapterSpinner;
import com.example.listadosymenus.pojos.Encapsulador;

import java.util.ArrayList;

public class MainActividad8 extends AppCompatActivity {

    private Spinner spinnerVersiones;
    private TextView tvTituloDetalle, tvDescripcionDetalle;
    private ArrayList<Encapsulador> datos;
    private VersionAdapterSpinner adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad8_layout);

        spinnerVersiones = findViewById(R.id.spinnerVersiones);
        tvTituloDetalle = findViewById(R.id.textViewTituloDetalle);
        tvDescripcionDetalle = findViewById(R.id.textViewDescripcionDetalle);

        cargarDatos();

        adaptador = new VersionAdapterSpinner(this, datos);
        spinnerVersiones.setAdapter(adaptador);

        spinnerVersiones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualizarSeleccion(position);
                adaptador.notifyDataSetChanged();

                Encapsulador seleccion = datos.get(position);
                tvTituloDetalle.setText(seleccion.getTitulo());
                tvDescripcionDetalle.setText(seleccion.getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Selección inicial
        actualizarSeleccion(0);
        adaptador.notifyDataSetChanged();
        tvTituloDetalle.setText(datos.get(0).getTitulo());
        tvDescripcionDetalle.setText(datos.get(0).getDescripcion());
    }

    private void actualizarSeleccion(int posicionSeleccionada) {
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setSeleccionado(false);
        }
        datos.get(posicionSeleccionada).setSeleccionado(true);
    }

    private void cargarDatos() {
        datos = new ArrayList<>();
        datos.add(new Encapsulador(R.drawable.donuts, "DONUTS", "El 15 de septiembre de 2009...", true));
        datos.add(new Encapsulador(R.drawable.froyo, "FROYO", "El 20 de mayo de 2010...", false));
        datos.add(new Encapsulador(R.drawable.gingerbread, "GINGERBREAD", "El 6 de diciembre de 2010...", false));
        datos.add(new Encapsulador(R.drawable.honeycomb, "HONEYCOMB", "El 22 de febrero de 2011...", false));
        datos.add(new Encapsulador(R.drawable.icecream, "ICE CREAM", "El SDK para Android 4.0.0...", false));
        datos.add(new Encapsulador(R.drawable.jellybean, "JELLY BEAN", "Google anunció Android 4.1...", false));
        datos.add(new Encapsulador(R.drawable.kitkat, "KITKAT", "Su nombre se debe a la chocolatina KitKat...", false));
        datos.add(new Encapsulador(R.drawable.lollipop, "LOLLIPOP", "Incluye Material Design...", false));
    }
}
