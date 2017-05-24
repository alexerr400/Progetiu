package com.example.u15161.progetiu;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.u15161.progetiu.jogo.Canva;

public class MainActivity extends AppCompatActivity {

    private LinearLayout canvao;
    private Canva canv;
    private int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        canv = new Canva(this);
        setContentView(canv);
    }

}
