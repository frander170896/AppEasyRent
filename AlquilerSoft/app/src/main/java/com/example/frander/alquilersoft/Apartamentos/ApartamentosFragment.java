package com.example.frander.alquilersoft.Apartamentos;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.example.frander.alquilersoft.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApartamentosFragment extends Fragment {
    private final static String[] Lugares = { "Guanacaste", "Heredia", "San Jose",
            "Limon", "Alajuela", "Cartago","Puntarenas" };
    private final static String[] Estado = { "Disponible", "Ocupado"};
    Activity activity;

    public ApartamentosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartamentos, container, false);
        activity = getActivity();
       /* ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,Lugares);
        Spinner lugares = (Spinner) view.findViewById(R.id.spnLugares);
        lugares.setAdapter(adapter);*/
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line, Lugares);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) view.findViewById(R.id.amSpnLugares);
        materialDesignSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line, Estado);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner) view.findViewById(R.id.amSpnEstado);
        materialDesignSpinner2.setAdapter(arrayAdapter2);
        return view;
    }

}
