package com.example.frander.alquilersoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Sign_in extends AppCompatActivity {

    private final static String[] tipoUsuario = {"Administrador", "Inquilino"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,tipoUsuario);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) findViewById(R.id.amSpnTipoUsario);
        materialDesignSpinner.setAdapter(arrayAdapter);
    }


}
