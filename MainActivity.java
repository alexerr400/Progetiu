package com.example.u15161.progetiu;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout canvao;
    private Birl teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        teste = new Birl(this);
        setContentView(teste);

    }

    private class Birl extends View
    {

        public Birl(Context context)
        {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            canvas.drawRect(10,10,15,15,paint);
            invalidate();
        }
    }
}
