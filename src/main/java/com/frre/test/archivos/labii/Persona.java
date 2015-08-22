package com.frre.test.archivos.labii;

import java.util.Date;

/**
 * Created by jvargas on 8/21/15.
 */
public class Persona {

    private String nombre;
    private int legajo;
    private Date fechaNac;

    public Persona(String nombre, int legajo, Date fechaNac) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaNac = fechaNac;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;

        Persona persona = (Persona) o;

        if (getLegajo() != persona.getLegajo()) return false;
        if (getNombre() != null ? !getNombre().equals(persona.getNombre()) : persona.getNombre() != null) return false;
        return !(getFechaNac() != null ? !getFechaNac().equals(persona.getFechaNac()) : persona.getFechaNac() != null);

    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + getLegajo();
        result = 31 * result + (getFechaNac() != null ? getFechaNac().hashCode() : 0);
        return result;
    }
}
