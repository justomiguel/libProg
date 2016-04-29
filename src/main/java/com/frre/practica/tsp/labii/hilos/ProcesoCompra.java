package com.frre.practica.tsp.labii.hilos;

import java.util.Random;

/**
 * Created by jvargas on 9/11/15.
 */
public class ProcesoCompra implements Comprable, Runnable{

    private String nombreProducto;
    private boolean exito;
    private int cantComprada;
    private DataStore dataStore;

    public ProcesoCompra(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public boolean getStatusCompra() {
        return exito;
    }

    @Override
    public void setStatusCompra(boolean comprada) {
        this.exito = comprada;
    }

    @Override
    public int getCantComprada() {
        return cantComprada;
    }

    @Override
    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    @Override
    public void run() {
        Random r = new Random();
        int cant = Math.abs(r.nextInt()%4)+1;
       // System.out.println(this+ " Por comprar "+cant);
        comprarProducto(cant);
       // System.out.println(this + " Status compra:" + getStatusCompra());
       // System.out.println(this +" Cant compra:"+getCantComprada());

    }

    private void comprarProducto(int cantAComprar) {
        dataStore.comprar(this, cantAComprar);
    }
}
