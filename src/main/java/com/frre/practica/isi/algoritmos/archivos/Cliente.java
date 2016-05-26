package com.frre.practica.isi.algoritmos.archivos;

import com.frre.library.Clave;
import com.frre.library.Fecha;

/**
 * Created by jvargas on 8/28/15.
 */
public class Cliente {


    @Clave
    private int legajo;
    private String nombre;
    private Fecha fecha;
    private double importe;

    @Override
    public String toString() {
        return "Cliente{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", importe=" + importe +
                '}';
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}


