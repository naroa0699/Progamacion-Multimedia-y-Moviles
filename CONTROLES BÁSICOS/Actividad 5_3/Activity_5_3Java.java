package com.example.controlesbasicos;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_5_3Java extends AppCompatActivity {

    private TextView tvMensaje;
    private Button btnBoton1, btnBoton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_3_java);

        tvMensaje = findViewById(R.id.tvMensaje);
        btnBoton1 = findViewById(R.id.btnBoton1);
        btnBoton2 = findViewById(R.id.btnBoton2);

        // Listener para el botón 1
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensaje.setText("Has pulsado el Botón 1");
            }
        });

        // Listener para el botón 2
        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensaje.setText("Has pulsado el Botón 2");
            }
        });
    }
}