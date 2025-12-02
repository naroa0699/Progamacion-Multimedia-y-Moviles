package com.example.preferenciasdialogosnotificaciones;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActividad1 extends AppCompatActivity implements View.OnClickListener {

    Button btnDefinir, btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad1);

        //1. Enlazar los componentes del layout (sin cambios)
        btnDefinir = findViewById(R.id.btnDefinirPreferencias);
        btnRecuperar = findViewById(R.id.btnRecuperarPreferencias);
        //2.Asignar el listener de clic a esta misma clase
        btnDefinir.setOnClickListener(this);
        btnRecuperar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.btnDefinirPreferencias){
            Intent intent = new Intent(this, PreferenciasAppActivity.class);
            startActivity(intent);
        }else if(id==R.id.btnRecuperarPreferencias){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            boolean unico50 = prefs.getBoolean("clave_check_unico_so",false);
            String sistema=prefs.getString("clave_lista_so","No seleccionado");
            String version=prefs.getString("clave_edit_version","No introducida");

            Log.d("PREFERENCIAS","--- Mostrando Preferencias Guardadas ---");
            Log.d("PREFERENCIAS","Unico S.O"+unico50);
            Log.d("PREFERENCIAS","Sistema Operativo: "+sistema);
            Log.d("PREFERENCIAS","Version: "+version);
        }
    }
}
