package com.example.u15161.progetiu.jogo;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by u15157 on 24/05/2017.
 */

public class Corredor /*extends Rect*/ {

    private int xA, yA, w, h, limite;

    public Corredor(int xI, int limite) {
        this(xI, 0, 100, 100, 1000);
        //super(xA, yA, w, h);
    }

    public Corredor(int xI, int yI, int wI, int hI, int limite) {
        this.xA = xI;
        this.yA = yI;
        this.w  = wI;
        this.h  = hI;

        //super(xA, yA, w, h);
    }

    public Corredor(){
        this((int)Math.random()*100, 0, 100, 100, 1000);
    }

    public void andar(){
        yA += 10;
    }

    public int alturaAtual() {
        return yA;
    }

    public int qtoFalta(){
        return limite - yA;
    }

    public boolean chegou(){
        return yA == limite;

    }

}
