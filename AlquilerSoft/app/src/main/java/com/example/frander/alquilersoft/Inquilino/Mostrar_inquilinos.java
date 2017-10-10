package com.example.frander.alquilersoft.Inquilino;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.frander.alquilersoft.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mostrar_inquilinos extends Fragment {
    ArrayList<Inquilino> inquilinos = new ArrayList<>();

    public Mostrar_inquilinos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mostrar_inquilinos, container, false);
        llenarListaInquilinos();
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.listaInquilinos);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adaptador_Inquilinos adaptador = new Adaptador_Inquilinos(inquilinos);
        rv.setAdapter(adaptador);
        return view;
    }
    private void llenarListaInquilinos() {
        inquilinos.add(new Inquilino("Erick","Hernández","5063-7689",R.mipmap.ic_erik));
        inquilinos.add(new Inquilino("Frander","Ramírez","6543-5436",R.mipmap.ic_frander));
        inquilinos.add(new Inquilino("Yoselin","Sanchez","8834-0987",R.mipmap.ic_yos));
        inquilinos.add(new Inquilino("Michael","Umaña","7809-0907",R.mipmap.ic_umana));
    }

}
