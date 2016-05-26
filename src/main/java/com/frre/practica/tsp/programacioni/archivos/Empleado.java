package com.frre.practica.tsp.programacioni.archivos;

import com.frre.library.Clave;

/**
 * Created by jvargas on 8/20/15.
 */
public class Empleado {

    @Clave
    private String provincia;
    @Clave
    private String localidad;
    @Clave
    private int dni;
    private String nomYAp;
    private double sueldo;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNomYAp() {
        return nomYAp;
    }

    public void setNomYAp(String nomYAp) {
        this.nomYAp = nomYAp;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "localidad='" + localidad + '\'' +
                ", nomYAp='" + nomYAp + '\'' +
                ", dni=" + dni +
                ", sueldo=" + sueldo +
                '}';
    }
}
