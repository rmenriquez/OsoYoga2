package com.osito.osoyoga;

/**
 * Created by RaquelMarcos on 27/12/17.
 */


public class JMudras {

    private String nombre_mudra;
    private String pasos_mudra;
    private String beneficios_mudra;
    private int id_mudra;

    public int getId_mudra() {
        return id_mudra;
    }

    public String getBeneficios_mudra() {
        return beneficios_mudra;
    }

    public String getNombre_mudra() {
        return nombre_mudra;
    }

    public String getPasos_mudra() {
        return pasos_mudra;
    }


    public JMudras(String nombre_mudra, String pasos_mudra, String beneficios_mudra, int id_mudra) {
        this.nombre_mudra = nombre_mudra;
        this.pasos_mudra = pasos_mudra;
        this.beneficios_mudra = beneficios_mudra;
        this.id_mudra = id_mudra;
    }
}