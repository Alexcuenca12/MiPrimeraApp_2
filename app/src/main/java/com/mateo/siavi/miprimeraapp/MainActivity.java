package com.mateo.siavi.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnIngreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Enlace con la vista
        btnIngreso=findViewById(R.id.btnIngreso);//Enlace con el elemento
        inicia_Control();
    }

    private void inicia_Control(){
        btnIngreso.setOnClickListener(v -> {
            //Enlace con el txtUsuario
            EditText txtUsuario =findViewById(R.id.txtUsuario);
            //Obtener el valor
            String usuario= txtUsuario.getText().toString();
            //Comunicacion entre las dos actividades con el intent
            Intent intent = new Intent(getApplicationContext(),MenuPrincipal.class);
            //Enviar toda la info al activity 2
            intent.putExtra("usuarioNombre",usuario);
            //Iniciar la activity enlace
            startActivity(intent);
        });
    }
}