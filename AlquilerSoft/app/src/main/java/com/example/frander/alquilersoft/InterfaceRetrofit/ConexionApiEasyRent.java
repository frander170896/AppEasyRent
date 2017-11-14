package com.example.frander.alquilersoft.InterfaceRetrofit;

import com.example.frander.alquilersoft.Canton.Canton;
import com.example.frander.alquilersoft.Distric.Distric;
import com.example.frander.alquilersoft.Province.Province;
import com.example.frander.alquilersoft.User.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

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


}
