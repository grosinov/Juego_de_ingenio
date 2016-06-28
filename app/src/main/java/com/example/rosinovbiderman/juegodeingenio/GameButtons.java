package com.example.rosinovbiderman.juegodeingenio;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageButton;

import java.util.Random;

public class GameButtons extends ImageButton {

    Boolean prendido;

    public GameButtons(Context context, AttributeSet attrs){
        super(context, attrs);
        refresh();
    }

    public boolean retornarPrendido(){ return prendido; }

    public void setPrendido(Boolean prendido) {
        this.prendido = prendido;
    }

    public Boolean getPrendido() {
        return prendido;
    }

    public void Color(){
        if(prendido){
            this.setBackgroundColor(Color.CYAN);
        } else {
            this.setBackgroundColor(Color.WHITE);
        }
    }

    public void cambiarColor(){
        prendido = !prendido;
        Color();
    }

    public void refresh(){
        prendido = new Random().nextBoolean();
        Color();
    }
}
