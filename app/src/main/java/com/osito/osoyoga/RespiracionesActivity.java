package com.osito.osoyoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RaquelMarcos on 27/12/17.
 */

public class RespiracionesActivity  extends AppCompatActivity {

    private final String TAG="MudraActivity";
    private static final int SEGUNDA_ACTIVIDAD = 2;
    private TextView Respiracion;
    private ImageView iRespiracion;
    private TextView tecnica;
    private int ultimaRespiracion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemcolumna);

        Respiracion= (TextView)findViewById(R.id.titulo);
        iRespiracion=(ImageView)findViewById(R.id.imagen);
        tecnica=(TextView)findViewById(R.id.pasos);
        Button SigRespiracion=(Button) findViewById(R.id.sig);
        Button Iniciar=(Button) findViewById(R.id.crono);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
                RespiracionesActivity.this.startActivityForResult(intent, SEGUNDA_ACTIVIDAD);
            }
        });


        SigRespiracion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cargarRespiraciones();
            }});
        ultimaRespiracion=1;
        cargarRespiraciones();
    }


    private void cargarRespiraciones() {

        switch (ultimaRespiracion){
            case 1:Respiracion.setText(getResources().getString(R.string.N_respiracion_1));
                tecnica.setText(getResources().getString(R.string.T_respiracion_1));
                iRespiracion.setImageResource(R.drawable.i_respiracion_1);
                break;
            case 2:Respiracion.setText(getResources().getString(R.string.N_respiracion_2));
                tecnica.setText(getResources().getString(R.string.T_respiracion_2));
                iRespiracion.setImageResource(R.drawable.i_respiracion_2);
                break;
            case 3:
                Respiracion.setText(getResources().getString(R.string.N_respiracion_3));
                tecnica.setText(getResources().getString(R.string.T_respiracion_3));
                iRespiracion.setImageResource(R.drawable.i_respiracion_3);
                break;
            case 4:Respiracion.setText(getResources().getString(R.string.N_respiracion_4));
                tecnica.setText(getResources().getString(R.string.T_respiracion_4));
                iRespiracion.setImageResource(R.drawable.i_respiracion_4);
                break;
            case 5:Respiracion.setText(getResources().getString(R.string.N_respiracion_5));
                tecnica.setText(getResources().getString(R.string.T_respiracion_5));
                iRespiracion.setImageResource(R.drawable.i_respiracion_5);
                break;
            case 6:Respiracion.setText(getResources().getString(R.string.N_respiracion_6));
                tecnica.setText(getResources().getString(R.string.T_respiracion_6));
                iRespiracion.setImageResource(R.drawable.i_respiracion_6);
                break;

        }


        if(ultimaRespiracion>=6) ultimaRespiracion=1;
        else{ ultimaRespiracion++;}


    }

}

