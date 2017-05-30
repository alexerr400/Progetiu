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

    Canvas tl;
    Corredor[] corre = new Corredor[5];
    Tiros[] bolas = new Tiros[21];
    float x,y,z;
    Paint br;



    public Jogao(Canvas desenho, Paint pa, float xis, float ylon, float ze){
        tl = desenho;
        br = pa;
        x = xis;
        y = ylon;
        z = ze;
    }


    @Override
    public void run() {
        tl.drawRect(x,y,200,200,br);
        try {
            Paint bru = new Paint();
            bru.setColor(Color.BLUE);
            tl.drawRect(100,100,200,200, bru);
            boolean chegou = false;
            while (!chegou) {
                bru.setColor(Color.RED);
                tl.drawRect(100,500,200,200, bru);

                for (int i = 0; i < 4; i++) {
                    if (corre[i] != null)
                        if (corre[i].chegou())
                            chegou = true;


                    if (corre[i] == null && corre.length < 4) {
                        corre[i] = new Corredor((int) Math.random() * 10, tl.getHeight());
                        System.out.println("AEE");
                    }

                    else if (corre[i] != null){
                        corre[i].andar();
                        tl.drawRect(corre[i].cara(), br);

                    }



                }

                boolean foi1 = false;
                for (int t = 0; t < 20; t++){
                    if (bolas[t] != null){
                        if (bolas[t].vazou(0))
                            bolas[t] = null;

                        bolas[t].vai();
                        tl.drawRect(bolas[t].getRect(), br);

                    }
                    else if (!foi1){
                        bolas[t] = new Tiros(tl.getWidth(), tl.getHeight(), 10, 10);
                        foi1 = true;
                    }
                }
                foi1 = false;

            /*    for (int i = 0; i < 3; i++)
                    for (int t = 0; i < 19; t++)
                        if (bolas[t] != null && corre[i] != null) {
                            if (bolas[t].matou(corre[i])) {
                                corre[i] = null;
                                bolas[t] = null;
                            }
                        }
*/


                sleep(100);

            }
        } catch (Exception ex){
            tl.drawText(ex.getMessage(),0,300,br);
            System.out.println(ex.getMessage());
        }
    }
}
