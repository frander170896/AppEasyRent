package com.example.frander.alquilersoft.Cobro;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.frander.alquilersoft.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class CobroFragment extends Fragment {
    private final static String[] Inquilinos = { "Frander Ramirez", "Erick Hernandez", "Yoseline Calvo",
            "Michael Umaña"};
    private final static String[]  Departamentos = { "#01", "#02","#03","#04"};
    Activity activity;

    public CobroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_cobro, container, false);
        activity = getActivity();
         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line,Inquilinos);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) view.findViewById(R.id.amApartamento);
        materialDesignSpinner.setAdapter(arrayAdapter);
/*
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line,Departamentos);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner) view.findViewById(R.id.amDepartamento);
        materialDesignSpinner2.setAdapter(arrayAdapter2);*/

        return view;
    }

}
