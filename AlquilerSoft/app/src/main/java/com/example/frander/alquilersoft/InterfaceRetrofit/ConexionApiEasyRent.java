package com.example.frander.alquilersoft.InterfaceRetrofit;

import com.example.frander.alquilersoft.Apartamentos.Apartamentos;
import com.example.frander.alquilersoft.Canton.Canton;
import com.example.frander.alquilersoft.Distric.Distric;
import com.example.frander.alquilersoft.Province.Province;
import com.example.frander.alquilersoft.User.User;
import com.example.frander.alquilersoft.User.UserId;
import com.example.frander.alquilersoft.User.UserLogin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Usuario on 22/10/2017.
 */

public interface ConexionApiEasyRent {

    /*@GET(ContenedorUrlApi.URL_USER)
    Call<User> obtenerUsuario();*/

    @GET(ContenedorUrlApi.URL_Province)
    Call<ArrayList<Province>> get_Provinces();

    @GET(ContenedorUrlApi.URL_Canton)
    Call<ArrayList<Canton>> get_Cantones();

    @GET(ContenedorUrlApi.URL_Distric)
    Call<ArrayList<Distric>> get_Distric();

    @POST(ContenedorUrlApi.URL_Insert_Apartament)
    Call<Boolean> add_apartament(@Body Apartamentos apartamentos);

    @GET(ContenedorUrlApi.URL_USER)
    Call<ArrayList<User>> getAllUser();

    @POST(ContenedorUrlApi.URL_LONGIN)
    Call<ArrayList<User>> login(@Body UserLogin userLogin);

    @POST(ContenedorUrlApi.URL_ADDUSER)
    Call<Boolean> addUser(@Body User user);

    @POST(ContenedorUrlApi.URL_GETAPARTMENTBYLESSEE)
    Call<ArrayList<Apartamentos>> getApartmentByLessee(@Body UserId userId);
}
