package com.example.frander.alquilersoft;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.frander.alquilersoft.InterfaceRetrofit.ConexionApiEasyRent;
import com.example.frander.alquilersoft.InterfaceRetrofit.ContenedorUrlApi;
import com.example.frander.alquilersoft.User.User;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    EditText fClave;

    TextInputLayout divNombre;
    TextInputLayout divApellido;
    TextInputLayout divEmail;
    TextInputLayout divConfClave;
    TextInputLayout divClave;


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
        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
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
        fClave = (EditText) findViewById(R.id.edtConfContraseña);
        registrarse = (Button) findViewById(R.id.boton_Registrar);
        progressBar = (ProgressBar) findViewById(R.id.progressBarRegister);

        divNombre = (TextInputLayout) findViewById(R.id.txtNombre);
        divApellido = (TextInputLayout) findViewById(R.id.txtApellido);
        divEmail = (TextInputLayout) findViewById(R.id.divCorreo);
        divConfClave = (TextInputLayout) findViewById(R.id.divConfContraseña);
        divClave = (TextInputLayout) findViewById(R.id.divContraseña);

        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validacionNombre(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        apellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validacionApellido(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validacionCorreo(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        clave.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validacionClave(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fClave.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String.valueOf(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,tipoUsuario);
        materialDesignSpinner = (MaterialBetterSpinner) findViewById(R.id.amSpnTipoUsario);
        materialDesignSpinner.setAdapter(arrayAdapter);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validacionNombre(nombre.getText().toString()) && validacionApellido(apellido.getText().toString()) &&
                        validacionCorreo(email.getText().toString()) && validacionClave(clave.getText().toString()) &&
                        validacionConfirmarClave(fClave.getText().toString()) && validacionTipoUsuario(materialDesignSpinner.getText().toString())){

                    User user = new User(nombre.getText().toString(),
                            apellido.getText().toString(), cedula.getText().toString(),
                            telefono1.getText().toString(), telefono2.getText().toString(),
                            email.getText().toString(), clave.getText().toString(),
                            numeroCuenta.getText().toString(), direccion.getText().toString(),
                            1);
                    if(materialDesignSpinner.getText().toString().equalsIgnoreCase("Inquilino")){
                        user.setUser_type_id(2);
                    }
                    ConexionApiEasyRent conexionApiEasyRent = retrofit.create(ConexionApiEasyRent.class);
                    Call<Boolean> addUser = conexionApiEasyRent.addUser(user);
                    addUser.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Registro Completo",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Sign_in.this, Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(),"No se puede registrar el usuario",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Problema de conexión",Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"Revisa que los campos con * estén debidamente llenados",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validacionNombre(String nombre){
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");
        if(!pattern.matcher(nombre).matches() || nombre.length()>30 || nombre.length() == 0){
            divNombre.setError("Debe ingresar su nombre");
            return false;
        }else{
            divNombre.setError(null);
        }
        return true;
    }

    private boolean validacionApellido(String apellido){
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");
        if(!pattern.matcher(apellido).matches() || apellido.length()>30 || apellido.length()==0){
            divApellido.setError("Debe ingresar sus apellidos");
            return false;
        }else{
            divApellido.setError(null);
        }
        return true;
    }

    private boolean validacionClave(String clave){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        if(!pattern.matcher(clave).matches() || clave.length()>30 || clave.length()<6){
            divClave.setError("La contraseña debe tener más de 5 caracteres");
            return false;
        }else{
            divClave.setError(null);
        }
        return true;
    }

    private boolean validacionCorreo(String correo){
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            divEmail.setError("El correo es inválido");
            return false;
        }else{
            divEmail.setError(null);
        }
        return true;
    }

    private boolean validacionConfirmarClave(String confClave){
        if(!confClave.equals(clave.getText().toString())){
            divConfClave.setError("Las contraseñas no coinciden");
            return false;
        }else{
            divConfClave.setError(null);
        }
        return true;
    }

    private boolean validacionTipoUsuario(String tipoUsuario){
        if(tipoUsuario.equals("")){
            return false;
        }else{
            return true;
        }
    }

}
