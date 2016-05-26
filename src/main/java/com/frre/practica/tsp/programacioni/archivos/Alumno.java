package com.frre.practica.tsp.programacioni.archivos;

import com.frre.library.Clave;

/**
 * Created by jvargas on 8/20/15.
 */
public class Alumno {


    @Clave
    private int legajo;

    @Clave
    private String nomYApell;

    private int dni;
    private double promedio;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNomYApell() {
        return nomYApell;
    }

    public void setNomYApell(String nomYApell) {
        this.nomYApell = nomYApell;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "legajo=" + legajo +
                ", nomYApell='" + nomYApell + '\'' +
                ", dni=" + dni +
                ", promedio=" + promedio +
                '}';
    }
}
