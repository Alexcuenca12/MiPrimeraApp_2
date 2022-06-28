package com.mateo.siavi.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Intent intent = getIntent();//Aqui se recibe el bundle o variables
        String usu= intent.getStringExtra("usuarioNombre");
        TextView txtVie= findViewById(R.id.txtMensaje);//Enlace
        txtVie.setText(usu);//Set del mensaje

    }
}