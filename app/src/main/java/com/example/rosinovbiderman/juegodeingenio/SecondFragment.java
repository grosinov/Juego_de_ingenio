package com.example.rosinovbiderman.juegodeingenio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    ListView lv;
    ArrayList<Jugadas> jugadas;
    MainActivity ma;
    jugadasAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        ma = (MainActivity)getActivity();
        jugadas = new ArrayList<Jugadas>();
        jugadas = ma.setLista();
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
            case R.id.nav_gallery:
                Log.d("gallery", "ison");
                break;
        }
        return true;
    }
}