package com.example.frander.alquilersoft;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    public static final int segundos = 8;
    public static final int milisegundos = segundos*1000;
    public ProgressBar progressBar;
    public static final int delay = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inicializadorInterfaz();
        comenzarAnimacion();
    }

    public void inicializadorInterfaz(){
        progressBar = (ProgressBar) findViewById(R.id.pbSplash);
        progressBar.setMax(maxio_progreso());
    }

    private void comenzarAnimacion() {
        new CountDownTimer(milisegundos,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent login = new Intent(Splash.this,Login.class);
                startActivity(login);
                finish();
            }
        }.start();
    }
    public int establecer_progreso(long miliseconds){
        return (int)((milisegundos-miliseconds)/1000);
    }
    public int maxio_progreso(){
        return segundos-delay;
    }


}
