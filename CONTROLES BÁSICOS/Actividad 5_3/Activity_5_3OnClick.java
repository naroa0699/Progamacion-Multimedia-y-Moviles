package com.example.controlesbasicos;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_5_3OnClick extends AppCompatActivity {

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_3_on_click);

        tvMensaje = findViewById(R.id.tvMensaje);
    }

    // Método llamado desde el atributo onClick del botón
    public void onBotonPulsado(View view) {
        tvMensaje.setText("¡Botón pulsado con onClick!");
    }
}