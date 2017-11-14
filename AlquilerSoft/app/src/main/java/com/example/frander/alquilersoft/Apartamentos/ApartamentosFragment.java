package com.example.frander.alquilersoft.Apartamentos;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.example.frander.alquilersoft.Canton.Canton;
import com.example.frander.alquilersoft.Distric.Distric;
import com.example.frander.alquilersoft.InterfaceRetrofit.ConexionApiEasyRent;
import com.example.frander.alquilersoft.InterfaceRetrofit.ContenedorUrlApi;
import com.example.frander.alquilersoft.Province.Province;
import com.example.frander.alquilersoft.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApartamentosFragment extends Fragment {

    ArrayList<Province> provincias;
    ArrayList<Canton> Cantones;
    ArrayList<Distric> Distritos;

    private static Retrofit retrofit;
    Spinner provinciasList;
    Spinner cantonesList;
    Spinner districList;
    Activity activity;

    public ApartamentosFragment() {
        // Required empty public constructor
    }

    public void crearConexionRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void get_Provinces(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Province>> listaProvincias = conexion.get_Provinces();
        listaProvincias.enqueue(new Callback<ArrayList<Province>>() {
            @Override
            public void onResponse(Call<ArrayList<Province>> call, Response<ArrayList<Province>> response) {
                if(response.isSuccessful()){
                    provincias = response.body();
                    ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                    provinciasList.setAdapter(adapter);
                }else {
                    provincias = new ArrayList<Province>();
                    provincias.add(new Province(0,"Vacio",0));
                    Log.i("Prueba2",provincias.size()+"" );
                    ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                    provinciasList.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Province>> call, Throwable t) {
                Log.i("Prueba5", t+"");
                provincias = new ArrayList<Province>();
                provincias.add(new Province(0,"Vacio",0));
                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                provinciasList.setAdapter(adapter);
            }
        });
    }
    private String[] getProvinceArray(ArrayList<Province> provincias) {
        String[] lista = new String[provincias.size()];
        for(int i = 0; i<provincias.size();i++){
            lista[i] = provincias.get(i).getName();
        }
        return lista;
    }
    private void get_Cantones(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Canton>> listaCantones = conexion.get_Cantones();
        listaCantones.enqueue(new Callback<ArrayList<Canton>>() {
            @Override
            public void onResponse(Call<ArrayList<Canton>> call, Response<ArrayList<Canton>> response) {
                if(response.isSuccessful()){
                    Cantones = response.body();
                }else {
                    Cantones = new ArrayList<Canton>();
                    Cantones.add(new Canton(0,"Vacio",0,0));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Canton>> call, Throwable t) {
                Cantones = new ArrayList<Canton>();
                Cantones.add(new Canton(0,"Vacio",0,0));
            }
        });
    }
    private void get_Distric(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Distric>> listaDistritos = conexion.get_Distric();
        listaDistritos.enqueue(new Callback<ArrayList<Distric>>() {
            @Override
            public void onResponse(Call<ArrayList<Distric>> call, Response<ArrayList<Distric>> response) {
                if(response.isSuccessful()){
                    Distritos = response.body();
                }else {
                    Distritos = new ArrayList<Distric>();
                    Distritos.add(new Distric(0,"Vacio",0,0));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Distric>> call, Throwable t) {
                Distritos = new ArrayList<Distric>();
                Distritos.add(new Distric(0,"Vacio",0,0));
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartamentos, container, false);
        provinciasList = (Spinner) view.findViewById(R.id.spProvincia);
        cantonesList = (Spinner) view.findViewById(R.id.spCanton);
        districList = (Spinner) view.findViewById(R.id.spDistrito);
        provinciasList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = (String) parent.getItemAtPosition(position);
                llenarSpinnerCantones(provincias,opcion,Cantones,cantonesList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cantonesList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = (String) parent.getItemAtPosition(position);
                llenarSpinnerDistrict(Cantones,opcion,Distritos,districList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        crearConexionRetrofit();
        get_Cantones();
        get_Provinces();

        activity = getActivity();

       /* ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,Lugares);
        Spinner lugares = (Spinner) view.findViewById(R.id.spnLugares);
        lugares.setAdapter(adapter);*/
       /* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line, Lugares);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) view.findViewById(R.id.amSpnLugares);
        materialDesignSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line, Estado);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner) view.findViewById(R.id.amSpnEstado);
        materialDesignSpinner2.setAdapter(arrayAdapter2);*/
        return view;
    }

    private void llenarSpinnerDistrict(ArrayList<Canton> cantones, String opcion, ArrayList<Distric> distritos, Spinner districList) {
        Canton canton =new Canton();
        ArrayList<Distric> distritosSeleccionados = new ArrayList<>();
        String[] lista;
        if(!cantones.isEmpty() && !distritos.isEmpty()){
            for(int i=0;i<cantones.size();i++){
                if(cantones.get(i).getName().equalsIgnoreCase(opcion)){
                    canton.setId(provincias.get(i).getId());
                    canton.setName(provincias.get(i).getName());
                    canton.setIs_active(provincias.get(i).getIs_active());
                    i=cantones.size();
                }
            }


            for(int j=0;j<distritos.size();j++){
                if(distritos.get(j).getId_canton() == canton.getId()){
                    distritosSeleccionados.add(distritos.get(j));
                }
            }

            if(!distritosSeleccionados.isEmpty()){
                lista = new String[distritosSeleccionados.size()];
                for(int m=0; m<distritosSeleccionados.size();m++){
                    lista[m]= distritosSeleccionados.get(m).getName();
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,lista);
                districList.setAdapter(adapter);
            }

        }
    }

    private void llenarSpinnerCantones(ArrayList<Province> provincias, String opcion, ArrayList<Canton> cantones, Spinner spCanton) {
        Province provincia =new Province();
        ArrayList<Canton> cantonesSeleccionados = new ArrayList<>();
        String[] lista;
        if(!provincias.isEmpty() && !cantones.isEmpty()){
            for(int i=0;i<provincias.size();i++){
                if(provincias.get(i).getName().equalsIgnoreCase(opcion)){
                    provincia.setId(provincias.get(i).getId());
                    provincia.setName(provincias.get(i).getName());
                    provincia.setIs_active(provincias.get(i).getIs_active());
                    i=provincias.size();
                }
            }


            for(int j=0;j<cantones.size();j++){
                if(cantones.get(j).getProvince_id() == provincia.getId()){
                    cantonesSeleccionados.add(cantones.get(j));
                }
            }

            if(!cantonesSeleccionados.isEmpty()){
                lista = new String[cantonesSeleccionados.size()];
                for(int m=0; m<cantonesSeleccionados.size();m++){
                    lista[m]= cantonesSeleccionados.get(m).getName();
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,lista);
                spCanton.setAdapter(adapter);
            }

        }
    }


}
