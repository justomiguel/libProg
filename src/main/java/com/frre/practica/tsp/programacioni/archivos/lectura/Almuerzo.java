package com.frre.practica.tsp.programacioni.archivos.lectura;

/**
 * Created by justo on 26/05/16.
 */
public class Almuerzo {

    private String nombreDelPlato;
    private double precio;
    private int cantComensales;

    public String getNombreDelPlato() {
        return nombreDelPlato;
    }

    public void setNombreDelPlato(String nombreDelPlato) {
        this.nombreDelPlato = nombreDelPlato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantComensales() {
        return cantComensales;
    }

    public void setCantComensales(int cantComensales) {
        this.cantComensales = cantComensales;
    }

    @Override
    public String toString() {
        return "Almuerzo{" +
                "nombreDelPlato='" + nombreDelPlato + '\'' +
                ", precio=" + precio +
                ", cantComensales=" + cantComensales +
                '}';
    }
}
