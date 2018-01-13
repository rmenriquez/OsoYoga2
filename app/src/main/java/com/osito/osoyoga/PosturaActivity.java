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

public class PosturaActivity extends MenuOpciones {

    private final String TAG="MudraActivity";
    private static final int SEGUNDA_ACTIVIDAD = 2;
    private TextView postura;
    private ImageView iPostura;
    private TextView coment;
    private TextView pasos;
    private int ultimaPostura;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemcolumna);

        postura= (TextView)findViewById(R.id.titulo);
        iPostura=(ImageView)findViewById(R.id.imagen);
        coment= (TextView)findViewById(R.id.comentario);
        pasos=(TextView)findViewById(R.id.pasos);
        Button SigPostura=(Button) findViewById(R.id.sig);
        Button Iniciar=(Button) findViewById(R.id.crono);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
                PosturaActivity.this.startActivityForResult(intent, SEGUNDA_ACTIVIDAD);
            }
        });

        SigPostura.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cargarPosturas();
            }});
        ultimaPostura=1;
        cargarPosturas();
    }



    private void cargarPosturas() {

        switch (ultimaPostura){
            case 1:postura.setText(getResources().getString(R.string.N_postura_1));
                coment.setText(getResources().getString(R.string.B_postura_1));
                pasos.setText(getResources().getString(R.string.P_postura_1));
                iPostura.setImageResource(R.drawable.i_postura_1);
                break;
            case 2:postura.setText(getResources().getString(R.string.N_postura_2));
                coment.setText(getResources().getString(R.string.B_postura_2));
                pasos.setText(getResources().getString(R.string.P_postura_2));
                iPostura.setImageResource(R.drawable.i_postura_2);
                break;
            case 3:
                postura.setText(getResources().getString(R.string.N_postura_3));
                coment.setText(getResources().getString(R.string.B_postura_3));
                pasos.setText(getResources().getString(R.string.P_postura_3));
                iPostura.setImageResource(R.drawable.i_postura_3);
                break;
            case 4:postura.setText(getResources().getString(R.string.N_postura_4));
                coment.setText(getResources().getString(R.string.B_postura_4));
                pasos.setText(getResources().getString(R.string.P_postura_4));
                iPostura.setImageResource(R.drawable.i_postura_4);
                break;
            case 5:postura.setText(getResources().getString(R.string.N_postura_5));
                coment.setText(getResources().getString(R.string.B_postura_5));
                pasos.setText(getResources().getString(R.string.P_postura_5));
                iPostura.setImageResource(R.drawable.i_postura_5);
                break;

        }


        if(ultimaPostura>=5) ultimaPostura=1;
        else{ ultimaPostura++;}


    }

}
