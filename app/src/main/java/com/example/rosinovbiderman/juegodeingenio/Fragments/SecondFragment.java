package com.example.rosinovbiderman.juegodeingenio.Fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rosinovbiderman.juegodeingenio.Jugadas;
import com.example.rosinovbiderman.juegodeingenio.MainActivity;
import com.example.rosinovbiderman.juegodeingenio.R;
import com.example.rosinovbiderman.juegodeingenio.jugadasAdapter;

import java.util.ArrayList;


public class SecondFragment extends Fragment {


    public SecondFragment() {

    }

    ListView lv;
    ArrayList<Jugadas> jugadas;
    MainActivity ma;
    jugadasAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jugadas = new ArrayList<Jugadas>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        ma = (MainActivity)getActivity();

        jugadas = ma.getLista();
        lv = (ListView) v.findViewById(R.id.list);
        adapter = new jugadasAdapter(this.getContext(),jugadas);
        lv.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.second,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_delete:
                Confirmacion().show();
                break;
        }
        return true;
    }

    private Dialog Confirmacion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Confirmacion");
        builder.setMessage("¿Esta seguro de que quiere borrar todas sus partidas?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jugadas.clear();
                adapter.notifyDataSetChanged();

                if(ma.baseDeDatosAbierta() == true){
                    ma.getBaseDatos().delete("Jugadas", "", null);
                }

                dialog.cancel();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}