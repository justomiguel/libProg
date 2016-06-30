package com.frre.practica.tsp.programacionii;

import com.frre.library.Generador;

/**
 * Created by jvargas on 8/21/15.
 */
public final class Main {

    private Main() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static void main(String[] args){

        Nodo first = null;
        for (int i = 0; i < 50; i++) {
            Nodo nuevo = new Nodo();
            nuevo.setValor(Generador.generarPalabraConArticuloAleatoria());
            //apilar
            //nuevo.setNext(first);
            //first = nuevo;

            //encolar
            if (first == null){
                first = nuevo;
            } else {
                Nodo aux = first;
                while (aux.getNext()!=null){
                    aux = aux.getNext();
                }
                aux.setNext(nuevo);
            }
        }

        //recorrer y eliminar
        Nodo aux = first;
        Nodo anterior = null;
        while (aux!=null){
            if (aux.getValor().equalsIgnoreCase("PAPA")){
                //elimino
                if (aux == first){
                    first = aux.getNext();
                } else {
                    anterior.setNext(aux.getNext());
                }
            }
            anterior = aux;
            aux = aux.getNext();
        }

    }
}
