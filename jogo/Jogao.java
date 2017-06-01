package com.example.u15161.progetiu.jogo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by u15157 on 24/05/2017.
 */

public class Jogao extends Thread {

    boolean chegou;
    Canva tl;
    Corredor[] corre = new Corredor[5];
    Tiros[] bolas = new Tiros[5];
    float x,y,z;
    int wC;



    public Jogao(Canva desenho, float xis, float ylon, float ze, int width){
        tl = desenho;
        chegou = false;
        x = xis;
        y = ylon;
        z = ze;
    }

    private int aleatorioX(){
        while 
    }

    public boolean chegou() {
        return chegou;
    }

    @Override
    public void run() {
        try {
            boolean chegou = false;
            int count = 0;
            while (!chegou) {

                for (int i = 0; i < corre.length; i++) {
                    if (corre[i] != null)
                        if (corre[i].chegou())
                            chegou = true;


                    if (corre[i] == null) {
                        corre[i] = new Corredor(((int) Math.random() * 100), 1, 10, 10, tl.getHeight());
                        System.out.println("AEE");
                    } else if (corre[i] != null) {
                        corre[i].andar();

                    }


                }

                for (int t = 0; t < bolas.length; t++) {
                    if (bolas[t] != null) {
                        if (bolas[t].vazou(0))
                            bolas[t] = null;

                        bolas[t].vai();

                    } else {
                        bolas[t] = new Tiros(tl.getWidth(), tl.getHeight(), 10, 10);
                        break;
                    }
                }

                count++;
                if (count == 4)
                    chegou = true;

            /*    for (int i = 0; i < 3; i++)
                    for (int t = 0; i < 19; t++)
                        if (bolas[t] != null && corre[i] != null) {
                            if (bolas[t].matou(corre[i])) {
                                corre[i] = null;
                                bolas[t] = null;
                            }
                        }
*/


                tl.setTudo(corre, bolas);
                tl.invalidate();
                sleep(100);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
