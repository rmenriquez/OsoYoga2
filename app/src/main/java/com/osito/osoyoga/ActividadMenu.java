package com.osito.osoyoga;

/**
 * Created by RaquelMarcos on 27/12/17.
 */





import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ActividadMenu extends AppCompatActivity {

    private static final int SEGUNDA_ACTIVIDAD = 2;
    private static final int TERCERA_ACTIVIDAD = 3;
    private static final int CUARTA_ACTIVIDAD = 4;
    private static final int QUINTA_ACTIVIDAD = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menu);

        ///BOTÓN RESPIRACIONES
        final Button botonResp = (Button) findViewById(R.id.bResp);
        botonResp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), RespiracionesActivity.class);
                ActividadMenu.this.startActivityForResult(intent, SEGUNDA_ACTIVIDAD);
            }
        });

        //BOTÓN MUDRAS
        final Button botonMud = (Button) findViewById(R.id.bMud);
        botonMud.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MudraActivity.class);
                ActividadMenu.this.startActivityForResult(intent, TERCERA_ACTIVIDAD);
            }
        });

        //BOTÓN POSTURAS
        final Button botonPost = (Button) findViewById(R.id.bPost);
        botonPost.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), PosturaActivity.class);
                ActividadMenu.this.startActivityForResult(intent, CUARTA_ACTIVIDAD);
            }
        });

        //BOTÓN SALIR
        final Button botonSalir = (Button) findViewById(R.id.bSalir);
        botonSalir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                AlertDialog.Builder mensajeConfirmacion = new AlertDialog.Builder(ActividadMenu.this);
                mensajeConfirmacion.setTitle(R.string.confirmarSalir);
                mensajeConfirmacion.setMessage(R.string.presionaSiSalir);

                mensajeConfirmacion.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                mensajeConfirmacion.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = mensajeConfirmacion.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

}

