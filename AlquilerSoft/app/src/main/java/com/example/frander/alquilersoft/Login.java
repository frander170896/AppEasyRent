package com.example.frander.alquilersoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.frander.alquilersoft.MenuUsuario.MenuUsuario;

/**
 * Created by Frander on 11/04/2017.
 */

public class Login extends AppCompatActivity {
    Button btnIngresar;
    Button btnRegistrarse;
    EditText cedula;
    EditText clave;
    ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        inicializadorInterfaz();
    }

    public void inicializadorInterfaz(){
        btnIngresar = (Button)findViewById(R.id.boton_aceptar);
        cedula = (EditText) findViewById(R.id.edtCedula);
        clave = (EditText) findViewById(R.id.edtContraseña);
        progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);

        btnRegistrarse = (Button)findViewById(R.id.boton_Registrarse);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String temCedula = cedula.getText().toString();
                String tempClave = clave.getText().toString();

                if(temCedula.equals("702460395") && tempClave.equals("1234")){
                    Intent intent = new Intent(Login.this,MenuPrincipal.class);
                    startActivity(intent);
                }else if(temCedula.equals("123456789") && tempClave.equals("123456")){
                    Intent intent = new Intent(Login.this,MenuUsuario.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"El usuario o la contraseña son incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Sign_in.class);
                startActivity(intent);
            }
        });
    }
}
