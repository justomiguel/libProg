package com.frre.test.archivos.labii.hilos;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by jvargas on 8/28/15.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        System.out.println("Testing 1 - Send Http GET request");

       // ExecutorService executor = Executors.newFixedThreadPool(7);

        DataStore dataStore = new DataStore("Leche", 10);

        ArrayList<Thread> hilos = new ArrayList<Thread>();
        ArrayList<ProcesoCompra> procesoCompras = new ArrayList<ProcesoCompra>();
        for (int i = 0; i < 1000; i++) {
            ProcesoCompra procesoCompra = new ProcesoCompra(dataStore);
            Thread nuevoHilo = new Thread(procesoCompra);
            hilos.add(nuevoHilo);
            procesoCompras.add(procesoCompra);
        }

        for (int i = 0; i < hilos.size(); i++) {
            hilos.get(i).start();
        }

        for (int i = 0; i < procesoCompras.size(); i++) {
            if (procesoCompras.get(i).getStatusCompra()){
                System.out.println(procesoCompras.get(i).getCantComprada());
            }
        }







    }


}
