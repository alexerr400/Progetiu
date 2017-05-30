package com.example.u15161.progetiu.jogo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


/**
 * Created by u15157 on 24/05/2017.
 */

public class Canva extends View{

    private Jogao game;
    float x,y,z;


    public Canva(Context ctx,float xis,float ylon,float ze) {
        super(ctx);
        x = xis;
        y = ylon;
        z = ze;
    }


    public void onDraw(Canvas canvas) {
        Paint brush = new Paint();
        brush.setColor(Color.BLACK);
        game = new Jogao(canvas, brush, x, y, z);

        game.run();

    }
}
