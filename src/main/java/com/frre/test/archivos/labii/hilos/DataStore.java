package com.frre.test.archivos.labii.hilos;

/**
 * Created by jvargas on 9/11/15.
 */
public class DataStore {

    private String productName;
    private int cantProductos;

    public DataStore(String productName, int cantProductos) {
        this.productName = productName;
        this.cantProductos = cantProductos;
    }

    public synchronized void comprar(Comprable productoComprable, int cantAComprar){
        if (cantProductos > 0){
            int afterPurchase = cantProductos - cantAComprar;
            if (afterPurchase <= 0){
                productoComprable.setCantComprada(cantProductos);
                cantProductos = 0;
            } else {
                productoComprable.setCantComprada(cantAComprar);
                cantProductos = afterPurchase;
            }
            productoComprable.setStatusCompra(true);
        } else {
            productoComprable.setStatusCompra(false);
        }

        //System.out.println("Stock "+ cantProductos);
    }
}
