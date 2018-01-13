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

public class MudraActivity extends MenuOpciones {

    private final String TAG="MudraActivity";
    private static final int SEGUNDA_ACTIVIDAD = 2;
    private TextView mudra;
    private ImageView iMudra;
    private TextView benf;
    private TextView instruc;
    private int ultimaMudra;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemcolumna);

        mudra= (TextView)findViewById(R.id.titulo);
        iMudra=(ImageView)findViewById(R.id.imagen);
        benf= (TextView)findViewById(R.id.comentario);
        instruc=(TextView)findViewById(R.id.pasos);
        Button OtraMudra=(Button) findViewById(R.id.sig);
        Button Iniciar=(Button) findViewById(R.id.crono);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
                MudraActivity.this.startActivityForResult(intent, SEGUNDA_ACTIVIDAD);
            }
        });

        OtraMudra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cargarMudras();
            }});
        ultimaMudra=1;
        cargarMudras();
    }


    private void cargarMudras() {

        switch (ultimaMudra){
            case 1:mudra.setText(getResources().getString(R.string.N_mudra_1));
                benf.setText(getResources().getString(R.string.B_mudra_1));
                instruc.setText(getResources().getString(R.string.P_mudra_1));
                iMudra.setImageResource(R.drawable.i_mudra_1);
                break;
            case 2:mudra.setText(getResources().getString(R.string.N_mudra_2));
                benf.setText(getResources().getString(R.string.B_mudra_2));
                instruc.setText(getResources().getString(R.string.P_mudra_2));
                iMudra.setImageResource(R.drawable.i_mudra_2);
                break;
            case 3:
                mudra.setText(getResources().getString(R.string.N_mudra_3));
                benf.setText(getResources().getString(R.string.B_mudra_3));
                instruc.setText(getResources().getString(R.string.P_mudra_3));
                iMudra.setImageResource(R.drawable.i_mudra_3);
                break;
            case 4:mudra.setText(getResources().getString(R.string.N_mudra_4));
                benf.setText(getResources().getString(R.string.B_mudra_4));
                instruc.setText(getResources().getString(R.string.P_mudra_4));
                iMudra.setImageResource(R.drawable.i_mudra_4);
                break;

        }


        if(ultimaMudra>=4) ultimaMudra=1;
        else{ ultimaMudra++;}


    }





}