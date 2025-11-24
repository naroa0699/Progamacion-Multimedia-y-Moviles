package com.example.controlesbasicos;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Activity_5_5 extends AppCompatActivity {

    private TextView tvResultado;
    private RadioGroup radioGroupDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_5);

        // Referencias
        tvResultado = findViewById(R.id.tvResultado);
        radioGroupDias = findViewById(R.id.radioGroupDias);

        // Listener para detectar qué RadioButton fue seleccionado
        radioGroupDias.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = findViewById(checkedId);

                if (rb != null) {
                    String texto = "PULSADO " + rb.getText().toString().toUpperCase();
                    tvResultado.setText(texto);
                }
            }
        });
    }
}
