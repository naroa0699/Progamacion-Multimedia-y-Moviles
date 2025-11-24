package com.example.controlesbasicos;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_5_4 extends AppCompatActivity {

    private EditText editTextPhone, editTextNumber, editTextEmail, editTextNumberPassword;
    private Button btnLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_4);

        // Referencias a los EditText
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword);

        // Botón para obtener datos
        btnLeer = findViewById(R.id.btnLeer);
        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = editTextPhone.getText().toString();
                String number = editTextNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String pin = editTextNumberPassword.getText().toString();

                if (TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(number) ||
                        TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(pin)) {

                    Toast.makeText(Activity_5_4.this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pin.length() != 4) {
                    Toast.makeText(Activity_5_4.this, "El PIN debe tener 4 dígitos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mostrar los datos (ejemplo)
                String mensaje = "Teléfono: " + phone +
                        "\nNúmero: " + number +
                        "\nEmail: " + email +
                        "\nPIN: " + pin;

                Toast.makeText(Activity_5_4.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}