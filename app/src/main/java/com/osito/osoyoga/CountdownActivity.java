package com.osito.osoyoga;

/**
 * Created by RaquelMarcos on 27/12/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class CountdownActivity extends MenuOpciones {

    private TextView countdownText;
    private Button countdownBotton;
    private Button stopButton;
    private int time;
    private String tiempoRestanteTexto;
    private String preferencias1;
    long preferencias2;
    private String tiempoRestantePrueba;

    private CountDownTimer countDownTimer;
    private long timeLeft=600000; //10 minutos
    private boolean timerRunning;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);

        countdownText=(TextView) findViewById(R.id.time_text);
        countdownBotton=(Button) findViewById(R.id.inicio);
        stopButton=(Button) findViewById(R.id.boton_parar);

        countdownBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
            }
        });

    }

    public void startStop(){
        if(timerRunning){
            pauseTimer();
        }else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft=l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        countdownBotton.setText("PAUSE");

        timerRunning= true;
    }

    public void pauseTimer(){
        countDownTimer.cancel();
        timerRunning=false;
        countdownBotton.setText("START");
    }

    public void stopTimer(){
        if(timerRunning){
            countDownTimer.cancel();
            timerRunning = false;
            countdownBotton.setText("START");
        }
        timeLeft = 600000;
        updateTimer();
    }

    public void updateTimer(){
        int min=(int) timeLeft/60000;
        int sec=(int) timeLeft%60000 /1000;

        String timeLeftText;
        timeLeftText= ""+ min;
        timeLeftText+= ":";

        if(sec<10) timeLeftText += "0";
        timeLeftText+=sec;

        countdownText.setText(timeLeftText);
    }

    @Override
    public void onPause(){
        super.onPause();
        if(timerRunning){
            pauseTimer();
        }
        SharedPreferences prefs = getSharedPreferences("preferenciasCronometro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("Tiemporestantenum", timeLeft);
        editor.commit();

    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = getBaseContext().getSharedPreferences("preferenciasCronometro", Context.MODE_PRIVATE);
        preferencias2 = prefs.getLong("Tiemporestantenum", 600000);
        timeLeft = preferencias2;
        updateTimer();

    }

}


