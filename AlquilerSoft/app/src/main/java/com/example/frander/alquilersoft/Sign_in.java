package com.example.frander.alquilersoft;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.frander.alquilersoft.User.User;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class Sign_in extends AppCompatActivity {

    private final static String[] tipoUsuario = {"Administrador", "Inquilino"};
    EditText nombre;
    EditText apellido;
    EditText cedula;
    EditText telefono1;
    EditText telefono2;
    EditText email;
    EditText numeroCuenta;
    EditText direccion;
    EditText clave;
    MaterialBetterSpinner materialDesignSpinner;
    Button registrarse;
    ProgressBar progressBar;
    ArrayList<User> userList;
    private Retrofit retrofit;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        nombre = (EditText) findViewById(R.id.edtNombre);
        apellido = (EditText) findViewById(R.id.edtApellido);
        cedula = (EditText) findViewById(R.id.edtCedula);
        telefono1 = (EditText) findViewById(R.id.edtTelefono);
        telefono2 = (EditText) findViewById(R.id.edtTelefono2);
        email = (EditText) findViewById(R.id.edtCorreo);
        numeroCuenta = (EditText) findViewById(R.id.edtNumeroCuenta);
        direccion = (EditText) findViewById(R.id.edtDireccion);
        clave = (EditText) findViewById(R.id.edtContraseña);
        registrarse = (Button) findViewById(R.id.boton_Registrar);
        progressBar = (ProgressBar) findViewById(R.id.progressBarRegister);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,tipoUsuario);
        materialDesignSpinner = (MaterialBetterSpinner) findViewById(R.id.amSpnTipoUsario);
        materialDesignSpinner.setAdapter(arrayAdapter);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(nombre.getText().toString(),
                        apellido.getText().toString(), cedula.getText().toString(),
                        telefono1.getText().toString(), telefono2.getText().toString(),
                        email.getText().toString(), clave.getText().toString(),
                        numeroCuenta.getText().toString(), direccion.getText().toString(),
                        1);
            }
        });
    }


}
