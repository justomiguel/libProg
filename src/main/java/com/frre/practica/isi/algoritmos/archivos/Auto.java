package com.frre.practica.isi.algoritmos.archivos;

import com.frre.library.Clave;

/**
 * Created by jvargas on 8/21/15.
 */
public class Auto {

    @Clave
    String localidad;
    String patente;
    String propietario;
    int modelo;

    @Override
    public String toString() {
        return "Auto{" +
                "localidad='" + localidad + '\'' +
                ", patente='" + patente + '\'' +
                ", propietario='" + propietario + '\'' +
                ", modelo=" + modelo +
                '}';
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
}
