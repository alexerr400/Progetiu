package com.example.u15161.progetiu.jogo;


import android.graphics.Rect;

/**
 * Created by u15157 on 24/05/2017.
 */

public class Tiros {
    int x, y, w, h, incX, incY;

    public Tiros(int xO, int yO, int incXO, int incYO) {
        this(xO, yO, 100, 100, incXO, incYO);
        //super(xA, yA, w, h);
    }

    public Tiros(int xI, int yI, int wI, int hI, int incXO, int incYO) {
        this.x = xI;
        this.y = yI;
        this.w  = wI;
        this.h  = hI;
        this.incX = incXO;
        this.incY = incYO;

        //super(xA, yA, w, h);
    }

    public Tiros(){
        this(1000, 400, 10, 10);
    }

    public void vai(){
        this.y += incY;
        this.x += incX;
    }

    public boolean matou(Corredor corre){
        Rect posicoes = corre.cara();
        return false;
    }
}
