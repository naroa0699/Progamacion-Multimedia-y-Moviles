package com.example.listadosymenus;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1_layout);

        // 1. Datos a mostrar
        String[] planetas = {
                "Mercurio", "Venus", "Tierra", "Marte",
                "Júpiter", "Saturno", "Urano", "Neptuno"
        };

        List<String> listaPlanetas = new ArrayList<>(Arrays.asList(planetas));

        // 2. Adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaPlanetas
        );

        // 3. Instanciamos el ListView
        ListView listView = findViewById(R.id.listViewPlanetas);


        TextView header = new TextView(this);
        header.setText("Planetas del Sistema Solar");
        header.setTextSize(22);
        header.setPadding(25, 25, 25, 25);
        header.setBackgroundColor(0xFFE0E0E0); // gris suave
        header.setTextColor(0xFF333333);


        TextView footer = new TextView(this);
        footer.setText("Powered by Naroa.");
        footer.setTextSize(14);
        footer.setPadding(25, 40, 25, 40);
        footer.setTextColor(0xFF666666);
        footer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        listView.addHeaderView(header);
        listView.addFooterView(footer);

        // 4. Asignamos adaptador
        listView.setAdapter(adapter);

        // 5. Listener de clic
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object item = parent.getItemAtPosition(position);

                if (item != null) {
                    Toast.makeText(getApplicationContext(),
                            "Has seleccionado: " + item.toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Has pulsado cabecera o pie",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
