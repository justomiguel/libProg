package com.frre.practica.tsp.programacioni.arreglos;

import java.util.Comparator;

/**
 * Created by justo on 12/05/16.
 */
public class ComparadorPersonas implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
