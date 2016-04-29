package com.frre.practica.tsp.programacionii.ejerciciolistas;

import com.frre.library.Generador;

/**
 * Created by jvargas on 8/28/15.
 */
public class Main {

    public static void main(String[] args){

        MiLista<String> miLista = new MiLista<String>();

        for (int i = 0; i < 23; i++) {
            Nodo<String> nodo = new Nodo<String>();
            nodo.setValue(Generador.generarPciaAleatorio());
            miLista.agregar(nodo);
        }

        int longitud = miLista.longitud();
        System.out.println("Longitud " + longitud);

        for (int i = 0; i <longitud; i++) {
            System.out.println(miLista.obtenerEn(i));
        }


        miLista.remover(15);

        longitud = miLista.longitud();

        System.out.println("Longitud " + longitud);
    }
}
