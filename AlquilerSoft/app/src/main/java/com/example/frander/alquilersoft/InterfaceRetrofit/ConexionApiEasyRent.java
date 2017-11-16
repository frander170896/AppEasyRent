package com.example.frander.alquilersoft.InterfaceRetrofit;

import com.example.frander.alquilersoft.User.User;
import com.example.frander.alquilersoft.User.UserLogin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Usuario on 22/10/2017.
 */

public interface ConexionApiEasyRent {

    @GET(ContenedorUrlApi.URL_USER)
    Call<ArrayList<User>> getAllUser();

    @POST(ContenedorUrlApi.URL_LONGIN)
    Call<ArrayList<User>> login(@Body UserLogin userLogin);

    @POST(ContenedorUrlApi.URL_ADDUSER)
    Call<Boolean> addUser(@Body User user);
}
