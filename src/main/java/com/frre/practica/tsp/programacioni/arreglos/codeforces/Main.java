package com.frre.practica.tsp.programacioni.arreglos.codeforces;

/**
 * Created by justo on 19/05/16.
 */
public final class Main {

    private Main() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static void main(String[] args){
        
    }
}

class Dragon {

    private int fuerza;
    private int bono;

    public Dragon(int fuerza, int bono) {
        this.fuerza = fuerza;
        this.bono = bono;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }
}
