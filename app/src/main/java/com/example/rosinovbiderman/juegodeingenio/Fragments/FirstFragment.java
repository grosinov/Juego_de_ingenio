package com.example.rosinovbiderman.juegodeingenio.Fragments;


import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rosinovbiderman.juegodeingenio.DataBase.DataBaseJuegoDeIngenio;
import com.example.rosinovbiderman.juegodeingenio.GameButtons;
import com.example.rosinovbiderman.juegodeingenio.Jugadas;
import com.example.rosinovbiderman.juegodeingenio.MainActivity;
import com.example.rosinovbiderman.juegodeingenio.R;

import java.util.ArrayList;


public class FirstFragment extends Fragment implements View.OnClickListener{

    public FirstFragment() {

    }

    GameButtons b1, b2, b3, b4, b5, b6, b7, b8, b9;
    public int clicks = 0;
    String clickeados = "";
    MainActivity ma;
    ArrayList<Jugadas> jugadas;
    Jugadas j;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jugadas = new ArrayList<Jugadas>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        b1 = (GameButtons) v.findViewById(R.id.ib1);
        b2 = (GameButtons) v.findViewById(R.id.ib2);
        b3 = (GameButtons) v.findViewById(R.id.ib3);
        b4 = (GameButtons) v.findViewById(R.id.ib4);
        b5 = (GameButtons) v.findViewById(R.id.ib5);
        b6 = (GameButtons) v.findViewById(R.id.ib6);
        b7 = (GameButtons) v.findViewById(R.id.ib7);
        b8 = (GameButtons) v.findViewById(R.id.ib8);
        b9 = (GameButtons) v.findViewById(R.id.ib9);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.first,menu);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.ib1:
                b1.cambiarColor();
                b2.cambiarColor();
                b4.cambiarColor();
                clicks++;
                clickeados += "Boton 1, ";
                break;
            case R.id.ib2:
                b1.cambiarColor();
                b2.cambiarColor();
                b3.cambiarColor();
                b5.cambiarColor();
                clicks++;
                clickeados += "Boton 2, ";
                break;
            case R.id.ib3:
                b2.cambiarColor();
                b3.cambiarColor();
                b6.cambiarColor();
                clicks++;
                clickeados += "Boton 3, ";
                break;
            case R.id.ib4:
                b4.cambiarColor();
                b1.cambiarColor();
                b5.cambiarColor();
                b7.cambiarColor();
                clicks++;
                clickeados += "Boton 4, ";
                break;
            case R.id.ib5:
                clicks++;
                b5.cambiarColor();
                b2.cambiarColor();
                b4.cambiarColor();
                b6.cambiarColor();
                b8.cambiarColor();
                clickeados += "Boton 5, ";
                break;
            case R.id.ib6:
                clicks++;
                b6.cambiarColor();
                b3.cambiarColor();
                b5.cambiarColor();
                b9.cambiarColor();
                clickeados += "Boton 6, ";
                break;
            case R.id.ib7:
                clicks++;
                b7.cambiarColor();
                b4.cambiarColor();
                b8.cambiarColor();
                clickeados += "Boton 7, ";
                break;
            case R.id.ib8:
                clicks++;
                b8.cambiarColor();
                b7.cambiarColor();
                b5.cambiarColor();
                b9.cambiarColor();
                clickeados += "Boton 8, ";
                break;
            case R.id.ib9:
                clicks++;
                b9.cambiarColor();
                b6.cambiarColor();
                b8.cambiarColor();
                clickeados += "Boton 9, ";
                break;
        }
        if(b1.getPrendido() && b2.getPrendido() && b3.getPrendido() && b4.getPrendido() && b5.getPrendido() && b6.getPrendido() && b7.getPrendido() && b8.getPrendido() && b9.getPrendido()){
            listar();
            ReinicioAlGanar().show();
        } else {
            if(!b1.getPrendido() && !b2.getPrendido() && !b3.getPrendido() && !b4.getPrendido() && !b5.getPrendido() && !b6.getPrendido() && !b7.getPrendido() && !b8.getPrendido() && !b9.getPrendido()){
                listar();
                ReinicioAlGanar().show();
            }
        }
    }

    public void listar(){
        ma = (MainActivity)getActivity();
        j = new Jugadas(ma.getUserName(), clicks, clickeados);
        jugadas.add(j);
        ma.setLista(jugadas);
        Insert();
        clicks = 0;
        clickeados = "";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_refresh:
                Reiniciar();
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);
                break;
        }
        return true;
    }

    private Dialog ReinicioAlGanar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Ha Ganado!");
        builder.setMessage("¿Desearia jugar una nueva paritda?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Reiniciar();
                dialog.cancel();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                b7.setEnabled(false);
                b8.setEnabled(false);
                b9.setEnabled(false);
                dialog.cancel();
            }
        });

        return builder.create();
    }

    public void Reiniciar(){
        b1.refresh();
        b2.refresh();
        b3.refresh();
        b4.refresh();
        b5.refresh();
        b6.refresh();
        b7.refresh();
        b8.refresh();
        b9.refresh();
        clicks = 0;
        clickeados = "";
    }

    public void Insert(){
        if(ma.baseDeDatosAbierta()){
            ContentValues nuevoRegistro;

            nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Nombre", ma.getUserName());
            nuevoRegistro.put("Clicks", clicks);
            nuevoRegistro.put("Clickeados", clickeados);

            ma.getBaseDatos().insert("Jugadas", null, nuevoRegistro);

            ma.getBaseDatos().close();}
    }
}