package com.example.listadosymenus;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadosymenus.adapters.VersionAdapter;
import com.example.listadosymenus.pojos.Encapsulador;

import java.util.ArrayList;


public class MainActividad6 extends AppCompatActivity {
    private ListView listViewVersiones;

    private TextView tvTituloDetalle,tvDescripcionDetalle,tvInfoInferior;

    private ArrayList<Encapsulador> datos;
    private VersionAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad6_layout);

        //1
        listViewVersiones = findViewById(R.id.listViewVersiones);
        tvTituloDetalle = findViewById(R.id.textViewTituloDetalle);
        tvDescripcionDetalle = findViewById(R.id.textViewDescripcionDetalle);
        tvInfoInferior = findViewById(R.id.textViewInfoInferior);

        //2
        cargarDatos();

        //3
        adaptador = new VersionAdapter(this,datos);
        listViewVersiones.setAdapter(adaptador);

        //4
        listViewVersiones.setOnItemClickListener((parent,view,position,id)->{
            actualizarSeleccion(position);

            adaptador.notifyDataSetChanged();

            Encapsulador seleccion = datos.get(position);
            tvTituloDetalle.setText(seleccion.getTitulo());
            tvDescripcionDetalle.setText(seleccion.getDescripcion());
            tvInfoInferior.setText(seleccion.getDescripcion());
        });

        actualizarSeleccion(0);
        adaptador.notifyDataSetChanged();
        Encapsulador primerElemento=datos.get(0);
        tvTituloDetalle.setText(primerElemento.getTitulo());
        tvDescripcionDetalle.setText(primerElemento.getDescripcion());
        tvInfoInferior.setText(primerElemento.getDescripcion());
    }

    private void actualizarSeleccion(int posicionSeleccionada){
        for(int i =0; i< datos.size();i++){
            datos.get(i).setSeleccionado(false);
        }
        datos.get(posicionSeleccionada).setSeleccionado(true);
    }

    private void cargarDatos(){
        datos = new ArrayList<>();
        datos.add(new Encapsulador(R.drawable.donuts, "DONUTS", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el núcleo Linux 2.6.29. En la actualización se incluyen numerosas características nuevas.", true));
        datos.add(new Encapsulador(R.drawable.froyo, "FROYO", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32.", false));
        datos.add(new Encapsulador(R.drawable.gingerbread, "GINGERBREAD", "El 6 de diciembre de 2010,el SDK de Android 2.3 Gingerbread (Pan de Jengibre) fue lanzado, basado en el núcleo Linux 2.6.35.", false));
        datos.add(new Encapsulador(R.drawable.honeycomb, "HONEYCOMB", "El 22 de febrero de 2011, sale el SDK de Android 3.0 Honeycomb (Panal de Miel). Fue la primera actualización exclusiva para TV y tableta, lo que quiere decir que sólo es apta para TV y tabletas y no para teléfonos Android.", false));
        datos.add(new Encapsulador(R.drawable.icecream, "ICE CREAM", "El SDK para Android 4.0.0 Ice Cream Sandwich (Sándwich de Helado), basado en el núcleo de Linux 3.0.1, fue lanzado públicamente el 12 de octubre de 2011.", false));
        datos.add(new Encapsulador(R.drawable.jellybean, "JELLY BEAN", "Google anunció Android 4.1 Jelly Bean (Gomita Confitada o Gominola) en la conferencia del 30 de junio de 2012. Basado en el núcleo de linux 3.0.31.", false));
        datos.add(new Encapsulador(R.drawable.kitkat, "KITKAT", "Su nombre se debe a la chocolatina KitKat, de la empresa internacional Nestlé. Posibilidad de impresión mediante WIFI. WebViews basadas en el motor de Chromium.", false));
        datos.add(new Encapsulador(R.drawable.lollipop, "LOLLIPOP", "Incluye Material Design, un diseño intrépido, colorido, y sensible interfaz de usuario para las experiencias coherentes e intuitivos en todos los dispositivos.", false));

    }
}
