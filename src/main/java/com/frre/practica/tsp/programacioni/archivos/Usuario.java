package com.frre.practica.tsp.programacioni.archivos;

import com.frre.library.Clave;

/**
 * Created by jvargas on 8/28/15.
 */
public class Usuario {

    @Clave
    private String domicilio;
    @Clave
    private int dni;
    private String nombre;
    private int edad;


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
