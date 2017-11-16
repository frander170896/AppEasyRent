package com.example.frander.alquilersoft.Publicaciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.frander.alquilersoft.Apartamentos.Apartamentos;
import com.example.frander.alquilersoft.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class publicacion_Apartamentos extends Fragment {
    ArrayList<Apartamentos> apartamentos = new ArrayList<>();
    RecyclerView rv;

    public publicacion_Apartamentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publicacion_apartamentos, container, false);
        rv = (RecyclerView) view.findViewById(R.id.listaPublicaciones);
        llenarLista();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdptadorPublicaciones adaptador = new AdptadorPublicaciones(apartamentos);
        rv.setAdapter(adaptador);
        return view;
    }

    private void llenarLista() {
        /*apartamentos.add(new Apartamentos(25000,"+506 5467-8798","Rio Frio la Victoria",3,R.mipmap.ic_p1));
        apartamentos.add(new Apartamentos(30000,"+506 6076-8778","Rio Frio la Victoria",2,R.mipmap.ic_p2));
        apartamentos.add(new Apartamentos(25000,"+506 8867-5498","Rio Frio la Victoria",1,R.mipmap.ic_p3));
        apartamentos.add(new Apartamentos(55000,"+506 5467-8798","Rio Frio la Victoria",3,R.mipmap.ic_p4));
        apartamentos.add(new Apartamentos(25000,"+506 8867-5498","Rio Frio la Victoria",4,R.mipmap.ic_p5));
        apartamentos.add(new Apartamentos(65000,"+506 6076-8778","Rio Frio la Victoria",1,R.mipmap.ic_p6));*/
    }

}
