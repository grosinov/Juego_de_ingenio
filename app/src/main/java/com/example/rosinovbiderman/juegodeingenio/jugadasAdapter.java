package com.example.rosinovbiderman.juegodeingenio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class jugadasAdapter extends BaseAdapter {

    ArrayList<Jugadas> jugadas;
    Context context;

    public jugadasAdapter (Context context, ArrayList<Jugadas> personas) {
        this.context = context;
        this.jugadas = personas;
    }

    @Override
    public int getCount() {
        return jugadas.size();
    }

    @Override
    public Object getItem(int i) {
        return jugadas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_view, viewGroup, false);
        }

        TextView nombreTV = (TextView)view.findViewById(R.id.nombre);
        TextView clicksTV = (TextView)view.findViewById(R.id.clicks);
        TextView clickeadosTV = (TextView)view.findViewById(R.id.clickeados);

        Jugadas j = jugadas.get(position);
        nombreTV.setText(j.getNombre());
        clicksTV.setText(String.valueOf(j.getClicks()));
        clickeadosTV.setText(j.getClickeados());

        return view;
    }
}
