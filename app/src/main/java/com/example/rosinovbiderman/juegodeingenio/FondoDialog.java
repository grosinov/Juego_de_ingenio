package com.example.rosinovbiderman.juegodeingenio;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by 41752347 on 21/6/2016.
 */
public class FondoDialog extends DialogFragment {
    public FondoDialog() {

    }
    ArrayList<String> colores;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fondo, container);

        final MainActivity mainActivity  = (MainActivity) getActivity(); // Politicamente incorrecto
        final Spinner fondo = (Spinner) view.findViewById(R.id.eligecolor);
        colores = new ArrayList<>();
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Amarillo");
        colores.add("Verde");
        ArrayAdapter<String> categAdapter;
        categAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,colores);
        categAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        fondo.setAdapter(categAdapter);

        Button b = (Button) view.findViewById(R.id.confirmar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","OK");
                String color = fondo.getSelectedItem().toString();
                mainActivity.setFondo(color);
                dismiss();
            }
        });
        getDialog().setTitle("Ingrese nombre de usuario");

        return view;
    }
}
