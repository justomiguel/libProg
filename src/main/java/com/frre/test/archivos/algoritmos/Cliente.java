package com.frre.test.archivos.algoritmos;

import com.frre.programacion.Clave;
import com.frre.programacion.Fecha;

/**
 * Created by jvargas on 8/28/15.
 */
public class Cliente {


    @Clave
    int legajo;
    String nombre;
    Fecha fecha;
    double importe;

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


