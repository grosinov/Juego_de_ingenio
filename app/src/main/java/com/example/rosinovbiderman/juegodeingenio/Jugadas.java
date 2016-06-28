package com.example.rosinovbiderman.juegodeingenio;

/**
 * Created by 41752347 on 28/6/2016.
 */
public class Jugadas {


    String nombre;
    int clicks;
    String clickeados;

    public Jugadas(String nombre, int clicks, String clickeados) {
        this.nombre = nombre;
        this.clicks = clicks;
        this.clickeados = clickeados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getClicks() {
        return clicks;
    }

    public String getClickeados() {
        return clickeados;
    }
}
