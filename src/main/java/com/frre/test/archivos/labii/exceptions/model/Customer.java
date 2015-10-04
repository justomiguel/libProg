package com.frre.test.archivos.labii.exceptions.model;

/**
 * Created by jvargas on 10/2/15.
 */
public class Customer {

    private int idUsuario;
    private String nombre;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
