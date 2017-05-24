package com.example.u15161.progetiu.jogo;

import android.graphics.Canvas;

/**
 * Created by u15157 on 24/05/2017.
 */

public class Jogao extends Thread {

    Canvas tl;
    Corredor[] corre = new Corredor[4];



    public Jogao(Canvas desenho){
        tl = desenho;
    }


    @Override
    public void run() {
        boolean chegou = false;
        while (!chegou) {
            

            for (int i = 0; i < 8; i++)
                if (corre[i].chegou())
                    chegou = true;
        }
    }
}
