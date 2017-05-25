package com.example.u15161.progetiu.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by u15157 on 24/05/2017.
 */

public class Jogao extends Thread {

    Canvas tl;
    Corredor[] corre = new Corredor[4];
    Tiros[] bolas = new Tiros[20];

    Paint br;



    public Jogao(Canvas desenho, Paint pa){
        tl = desenho;
        br = pa;

    }


    @Override
    public void run() {
        try {
            boolean chegou = false;
            while (!chegou) {


                for (int i = 0; i < 4; i++) {
                    if (corre[i].chegou())
                        chegou = true;


                    if (corre[i] == null && corre.length < 4)
                        corre[i] = new Corredor((int)Math.random()*10, tl.getHeight());
                    else{
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
                    else if (!foi1 || bolas.length >= 20){
                        bolas[t] = new Tiros(tl.getWidth(), tl.getHeight(), 10, 10);
                    }
                }

                for (int i = 0; i < 4; i++)
                    for (int t = 0; i < 20; t++)
                        if (bolas[t].matou(corre[i])) {
                            corre[i] = null;
                            bolas[t] = null;
                        }



                sleep(10);

            }
        } catch (Exception ex){

        }
    }
}
