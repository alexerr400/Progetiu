package com.example.u15161.progetiu.jogo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by u15157 on 24/05/2017.
 */

public class Canva extends View{

    private Jogao game;
    float x,y,z;
    private Paint brush;
    private Corredor[] corre = new Corredor[5];
    private Tiros[] tiro = new Tiros[21];
    private boolean chegou;


    public Canva(Context ctx,float xis,float ylon,float ze) {
        super(ctx);
        x = xis;
        y = ylon;
        z = ze;
        chegou = false;



    }


    public void setTudo(Corredor[] nc, Tiros[] nt){
        corre = nc;
        tiro = nt;
    }


    public void onDraw(Canvas canvas) {
        brush = new Paint();
        brush.setColor(Color.BLACK);
        canvas.drawRect(0,0,100,100, brush);
        for (int i = 0; i < corre.length; i++){
            if (corre[i] != null){
                canvas.drawRect(corre[i].getCara(), brush);
            }
        }
        for (int i = 0; i < tiro.length; i++){
            if (tiro[i] != null){
                canvas.drawRect(tiro[i].getTiro(), brush);
            }
        }

    }


}
