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
    Tiros[] bolas = new Tiros[21];
    float x,y,z;



    public Jogao(Canva desenho, float xis, float ylon, float ze){
        tl = desenho;
        chegou = false;
        x = xis;
        y = ylon;
        z = ze;
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

                for (int i = 0; i < 4; i++) {
                    if (corre[i] != null)
                        if (corre[i].chegou())
                            chegou = true;


                    if (corre[i] == null && corre.length < 4) {
                        corre[i] = new Corredor((int) Math.random() * 10, tl.getHeight());
                        System.out.println("AEE");
                    } else if (corre[i] != null) {
                        corre[i].andar();

                    }


                }

                boolean foi1 = false;
                for (int t = 0; t < 20; t++) {
                    if (bolas[t] != null) {
                        if (bolas[t].vazou(0))
                            bolas[t] = null;

                        bolas[t].vai();

                    } else if (!foi1) {
                        bolas[t] = new Tiros(tl.getWidth(), tl.getHeight(), 10, 10);
                        foi1 = true;
                    }
                }
                foi1 = false;

                count++;
                if (count == 3)
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
