package com.example.controlesbasicos;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.ITALIC;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Activity_5_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_1);

        TextView tvContenido = findViewById(R.id.tvContenido);

        /*
         * EJEMPLO 5.1.1 – TEXTO DESDE XML
         * No necesitas código. Ya está en el layout.
         */

        /*
         * EJEMPLO 5.1.2 – TEXTO DESDE JAVA (italic y azul)
         */
//        tvContenido.setText("Texto construido desde Java\nTamaño 20dp, Italic y color Blue.");
//        tvContenido.setTextColor(Color.BLUE);
//        tvContenido.setTypeface(null, ITALIC);
//        tvContenido.setTextSize(20);

        /*
         * EJEMPLO 5.1.3 – XML + append desde Java
         */
//        tvContenido.append("\nTexto añadido con append desde Java.");
//        tvContenido.setTextColor(Color.RED);

        /*
         * EJEMPLO 5.1.4 – FUENTE DESCARGADA
         */
        Typeface typeface = ResourcesCompat.getFont(this, R.font.pacifico_regular);
        tvContenido.setTypeface(typeface);
        tvContenido.setText("TEXTO ESCRITO CON FUENTE PACIFICO");
        tvContenido.setTextColor(Color.BLUE);
        tvContenido.setTextSize(20);
    }
}
