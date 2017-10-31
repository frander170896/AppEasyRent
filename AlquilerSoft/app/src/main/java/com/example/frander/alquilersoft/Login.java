package com.example.frander.alquilersoft;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.frander.alquilersoft.InterfaceRetrofit.ConexionApiEasyRent;
import com.example.frander.alquilersoft.InterfaceRetrofit.ContenedorUrlApi;
import com.example.frander.alquilersoft.MenuUsuario.MenuUsuario;
import com.example.frander.alquilersoft.User.User;
import com.example.frander.alquilersoft.User.UserLogin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Frander on 11/04/2017.
 */

public class Login extends AppCompatActivity {
    Button btnIngresar;
    Button btnRegistrarse;
    EditText cedula;
    EditText clave;
    ProgressBar progressBar;
    ArrayList<User> userList;
    private Retrofit retrofit;
    private SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
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
                final UserLogin userLogin = new UserLogin(temCedula, tempClave);

                ConexionApiEasyRent conexionApiEasyRent = retrofit.create(ConexionApiEasyRent.class);

                Call<ArrayList<User>> verifyUser = conexionApiEasyRent.login(userLogin);

                verifyUser.enqueue(new Callback<ArrayList<User>>() {
                    @Override
                    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                        if (response.isSuccessful()){
                            userList = response.body();
                            SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
                            preferenceEditor.putInt("id", userList.get(0).getId());
                            preferenceEditor.putString("Nombre", userList.get(0).getName());
                            preferenceEditor.putString("Apellidos", userList.get(0).getLast_name());
                            preferenceEditor.putString("numeroCuenta", userList.get(0).getAccount_number());
                            preferenceEditor.putString("cedula", userList.get(0).getIdentification_card());
                            preferenceEditor.putString("email", userList.get(0).getEmail());
                            Intent intent = new Intent(Login.this,MenuPrincipal.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_LONG).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Datos Incorrectos: ",Toast.LENGTH_LONG).show();
                    }
                });

                /*if(temCedula.equals("702460395") && tempClave.equals("1234")){
                    Intent intent = new Intent(Login.this,MenuPrincipal.class);
                    startActivity(intent);
                }else if(temCedula.equals("123456789") && tempClave.equals("123456")){
                    Intent intent = new Intent(Login.this,MenuUsuario.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"El usuario o la contraseña son incorrectos",Toast.LENGTH_LONG).show();
                }*/
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
