package com.example.frander.alquilersoft.Apartamentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.frander.alquilersoft.Inquilino.Adaptador_Inquilinos;
import com.example.frander.alquilersoft.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostrarApartamentosFragment extends Fragment {

    RecyclerView rv;
    ArrayList<Apartamentos> apartamentos = new ArrayList<>();
    public MostrarApartamentosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mostrar_apartamentos, container, false);
        llenarApartamentos();
        rv = (RecyclerView) view.findViewById(R.id.listaDepas);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdaptadorMostrarDepas adaptador= new AdaptadorMostrarDepas(apartamentos);
        rv.setAdapter(adaptador);

        return view;
    }

    private void llenarApartamentos() {
       /* apartamentos.add(new Apartamentos(1,1,25000,"La victoria,Rio Frio",1,0,R.mipmap.ic_p1));
        apartamentos.add(new Apartamentos(2,2,35000,"La victoria,Rio Frio",3,1,R.mipmap.ic_p2));
        apartamentos.add(new Apartamentos(3,3,35000,"La victoria,Rio Frio",3,1,R.mipmap.ic_p3));
        apartamentos.add(new Apartamentos(4,4,35000,"La victoria,Rio Frio",3,1,R.mipmap.ic_p4));
        apartamentos.add(new Apartamentos(5,5,35000,"La victoria,Rio Frio",3,1,R.mipmap.ic_p5));*/
    }

}
