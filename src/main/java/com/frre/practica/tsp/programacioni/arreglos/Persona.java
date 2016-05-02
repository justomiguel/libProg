package com.frre.practica.tsp.programacioni.arreglos;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by jvargas on 8/21/15.
 */
public class Persona {

    private String nombre;
    private int legajo;
    private String[] sobreNombres;

    public Persona(String nombre, int legajo, String[] sobreNombres) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.sobreNombres = sobreNombres;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", legajo=" + legajo +
                ", sobreNombres=" + Arrays.toString(sobreNombres) +
                '}';
    }

    public String[] getSobreNombres() {
        return sobreNombres;
    }

    public void setSobreNombres(String[] sobreNombres) {
        this.sobreNombres = sobreNombres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }


}
