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


    public Canva(Context ctx) {
        super(ctx);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint brush = new Paint();
        brush.setColor(Color.BLACK);
        game = new Jogao(canvas);

        game.run();

    }
}
