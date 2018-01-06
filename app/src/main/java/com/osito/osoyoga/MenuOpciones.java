package com.osito.osoyoga;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by jlbor on 06/01/2018.
 */

public class MenuOpciones extends AppCompatActivity{

    private static final int SEGUNDA_ACTIVIDAD = 2;
    private static final int TERCERA_ACTIVIDAD = 3;
    private static final int CUARTA_ACTIVIDAD = 4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate(R.menu.actions_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        boolean toret = false;
        switch (menuItem.getItemId()){
            case R.id.resp:
                Intent intent = new Intent(getApplicationContext(), RespiracionesActivity.class);
                MenuOpciones.this.startActivityForResult(intent, SEGUNDA_ACTIVIDAD);
                break;
            case R.id.mud:
                Intent intent2 = new Intent(getApplicationContext(), MudraActivity.class);
                MenuOpciones.this.startActivityForResult(intent2, TERCERA_ACTIVIDAD);
                break;
            case R.id.post:
                Intent intent3 = new Intent(getApplicationContext(), PosturaActivity.class);
                MenuOpciones.this.startActivityForResult(intent3, CUARTA_ACTIVIDAD);
                break;
            case R.id.rut:

                break;
            case R.id.salir:
                AlertDialog.Builder mensajeConfirmacion = new AlertDialog.Builder(MenuOpciones.this);
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
                break;
        }
        return toret;
    }
}
