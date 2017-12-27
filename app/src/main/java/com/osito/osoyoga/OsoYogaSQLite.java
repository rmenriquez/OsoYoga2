package com.osito.osoyoga;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by RaquelMarcos on 27/12/17.
 */

public class OsoYogaSQLite extends SQLiteOpenHelper {

    private final String TAG= "OsoYogaSQLite";
    private Context mContext;
    private int DATABASE_VERSION;
    private String DATABASE_ASETS_FILE;
    private String DATABASE_NAME;
    private String DATABASE_PATH;


    public boolean mCopiarBD;


    public OsoYogaSQLite(Context context, String name, int version) {
        super(context, name, null, version);
        mContext = context;
        DATABASE_NAME = name;
        DATABASE_ASETS_FILE = String.format("%s.sqlite", name);
        DATABASE_VERSION = version;

        DATABASE_PATH = "data/data/com.example.jlbor.yoga/databases/";

        try {
            String bd_path = String.format("%s%s", DATABASE_PATH, DATABASE_NAME);
            File bd_file = new File(bd_path);
            if (bd_file.exists()) {
                mCopiarBD = false;
            } else {
                mCopiarBD = true;
            }
        }catch(Exception e){
            Log.e(TAG, "OsoYogaSQLite: " + e.getMessage());
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void onOpen(SQLiteDatabase db){
        try {
            if(mCopiarBD) copyDB();
        } catch(Exception e){
            Log.e(TAG, "onOpen-CopiarBD: " + e.getMessage());
        }
        super.onOpen(db);
    }

    private void copyDB() throws IOException {
        try {
            InputStream myImput= mContext.getAssets().open(DATABASE_ASETS_FILE);
            String outFileName= DATABASE_PATH + DATABASE_NAME;
            OutputStream myOutput= new FileOutputStream(outFileName);

            byte[] buffer= new byte[1024];
            int length;
            while ((length=myImput.read(buffer))>0) myOutput.write(buffer, 0, length);

            myOutput.flush();
            myOutput.close();
            myImput.close();
        }catch(Exception e){
            Log.e(TAG, "copyBD: " + e.getMessage());
        }

    }











    public JMudras cargarMudra(int ultimaMudra){

        JMudras mudra=null;


        try{
            String selectQuery= String.format("Select * from Mudras where nombre_mudra<>'%s' order by Random() limit 1", ultimaMudra);
            SQLiteDatabase db= this.getReadableDatabase();
            Cursor cursor= db.rawQuery(selectQuery,null);


            if(cursor.moveToFirst()){
                mudra= new JMudras(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3   ));
            }
            db.close();

        }catch(Exception e){
            Log.e(TAG, "CargarMudra: " + e.getMessage());
        }

        return mudra;
    }





}