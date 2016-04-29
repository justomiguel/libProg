package com.frre.practica.tsp.labii.exceptions.exceptions;

import com.frre.practica.tsp.labii.exceptions.model.Compra;

/**
 * Created by jvargas on 10/2/15.
 */
public class ZeroComprasException extends Exception {

    private static final String MESSAGE = "El usuario posee una compra de valor 0";

    private Compra compra;

    public ZeroComprasException(Compra compra) {
        super(MESSAGE);
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }
}
