package com.example.frander.alquilersoft.InterfaceRetrofit;

import com.example.frander.alquilersoft.User.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Usuario on 22/10/2017.
 */

public interface ConexionApiEasyRent {

    @GET(ContenedorUrlApi.URL_USER)
    Call<User> obtenerUsuario();
}
