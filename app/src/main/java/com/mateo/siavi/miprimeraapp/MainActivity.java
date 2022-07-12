package com.mateo.siavi.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btnIngreso;
    Button btnRegistro;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Enlace con la vista
        firebaseAuth=FirebaseAuth.getInstance();
        btnIngreso=findViewById(R.id.btnIngreso);//Enlace con el elemento
        btnRegistro=findViewById(R.id.btnRegistro);//Enlace con el elemento
        inicioControl();
    }

    private void inicioControl(){
        btnRegistro.setOnClickListener(l-> registro_Usuario());
        btnIngreso.setOnClickListener(l-> ingreso_Usuario());
    }

    private void registro_Usuario(){
        EditText txt_Usuario = findViewById(R.id.txtUsuario);
        EditText txtPass = findViewById(R.id.txtPassword);

        if (!txt_Usuario.getText().toString().isEmpty()){
            firebaseAuth.getInstance().createUserWithEmailAndPassword(txt_Usuario.getText().toString(),txtPass.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Registro Correcto",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"ERROR Registro",Toast.LENGTH_LONG).show();
                            }

                        }
                    }
            );
        }

    }

    private void ingreso_Usuario(){
        EditText txt_Usuario =findViewById(R.id.txtUsuario);
        EditText txtPass = findViewById(R.id.txtPassword);

        if (!txt_Usuario.getText().toString().isEmpty()){
            firebaseAuth.signInWithEmailAndPassword(txt_Usuario.getText().toString(),txtPass.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                cambiarPantalla();
                                Toast.makeText(getApplicationContext(),"Ingreso Correcto",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"ERROR Ingreso",Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                    );
        }

    }

    private void cambiarPantalla(){
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