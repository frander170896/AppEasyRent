package com.example.frander.alquilersoft.Apartamentos;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.frander.alquilersoft.Inquilino.Adaptador_Inquilinos;
import com.example.frander.alquilersoft.InterfaceRetrofit.ConexionApiEasyRent;
import com.example.frander.alquilersoft.InterfaceRetrofit.ContenedorUrlApi;
import com.example.frander.alquilersoft.R;
import com.example.frander.alquilersoft.User.User;
import com.example.frander.alquilersoft.User.UserId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostrarApartamentosFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static ArrayList<Apartamentos> apartamentos;
    private SharedPreferences sharedPreferences;
    private static Retrofit retrofit;
    private ProgressBar barraProgeso;
    RecyclerView rv;
    View view;

    public MostrarApartamentosFragment() {
        // Required empty public constructor
    }

    public static MostrarApartamentosFragment newInstance(int sectionNumber) {
        MostrarApartamentosFragment fragment = new MostrarApartamentosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return fragment;
    }

    private void llenarApartamentos() {
        UserId temp = new UserId(sharedPreferences.getInt("id",1));
        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Apartamentos>> listaApartamentos =
                conexion.getApartmentByLessee(temp);
        listaApartamentos.enqueue(new Callback<ArrayList<Apartamentos>>() {
            @Override
            public void onResponse(Call<ArrayList<Apartamentos>> call, Response<ArrayList<Apartamentos>> response) {
                barraProgeso.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    apartamentos = response.body();
                    AdaptadorMostrarDepas adapter = new AdaptadorMostrarDepas(apartamentos, getContext());
                    rv.setAdapter(adapter);
                }else{
                    Toast.makeText(getActivity(),"Hola"+response.body(),Toast.LENGTH_LONG).show();
                    apartamentos = new ArrayList<Apartamentos>();
                    apartamentos.add(new Apartamentos(0, 0, 0, 0, 0,
                            0, 0, "No hay datos", "No hay datos",
                            "Sin direccion", "Sin imagen", "Sin distrito", "Sin estado"));
                    AdaptadorMostrarDepas adapter = new AdaptadorMostrarDepas(apartamentos, getContext());
                    rv.setAdapter(adapter);
                }
                Log.i("respuesta","datos: " + response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Apartamentos>> call, Throwable t) {
                barraProgeso.setVisibility(View.GONE);
                apartamentos = new ArrayList<Apartamentos>();
                apartamentos.add(new Apartamentos(0, 0, 0, 0, 0,
                0, 0, "Error de Conexion", "Error de Conexion",
                        "Sin direccion", "Sin imagen", "Sin distrito", "Sin estado"));
                AdaptadorMostrarDepas adapter = new AdaptadorMostrarDepas(apartamentos, getContext());
                rv.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mostrar_apartamentos, container, false);
        barraProgeso = (ProgressBar) view.findViewById(R.id.progressBarApartments);
        sharedPreferences = this.getActivity().getSharedPreferences("userLoginPreference", Context.MODE_PRIVATE);

        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rv = (RecyclerView) view.findViewById(R.id.listaDepas);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        llenarApartamentos();
        return view;
    }

}
