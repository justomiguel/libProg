package com.frre.practica.isi.algoritmos.archivos;

import com.frre.library.Clave;

/**
 * Created by jvargas on 8/28/15.
 */
public class Bono {

    @Clave
    private String provincia;

    private double bono;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }


}
