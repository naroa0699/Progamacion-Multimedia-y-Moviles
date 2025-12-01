package com.example.listadosymenus;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadosymenus.adapters.VersionAdapter;
import com.example.listadosymenus.pojos.Encapsulador;

import java.util.ArrayList;

public class MainActividad7 extends AppCompatActivity {

    private GridView gridViewVersiones;
    private TextView tvTituloDetalle,tvDescripcionDetalle,tvInfoInferior;
    private ArrayList<Encapsulador> datos;
    private VersionAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad7_layout);

        // 1. Inicialización de vistas
        gridViewVersiones = findViewById(R.id.gridViewVersiones);
        tvTituloDetalle = findViewById(R.id.textViewTituloDetalle);
        tvDescripcionDetalle = findViewById(R.id.textViewDescripcionDetalle);

        // 2. Cargar datos
        cargarDatos();

        // 3. Crear adaptador
        adaptador = new VersionAdapter(this, datos);
        gridViewVersiones.setAdapter(adaptador);

        // 4. Manejar selección de items
        gridViewVersiones.setOnItemClickListener((parent, view, position, id) -> {
            actualizarSeleccion(position);
            adaptador.notifyDataSetChanged();

            Encapsulador seleccion = datos.get(position);
            tvTituloDetalle.setText(seleccion.getTitulo());
            tvDescripcionDetalle.setText(seleccion.getDescripcion());
        });

        // Selección inicial
        actualizarSeleccion(0);
        adaptador.notifyDataSetChanged();
        Encapsulador primerElemento = datos.get(0);
        tvTituloDetalle.setText(primerElemento.getTitulo());
        tvDescripcionDetalle.setText(primerElemento.getDescripcion());
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

