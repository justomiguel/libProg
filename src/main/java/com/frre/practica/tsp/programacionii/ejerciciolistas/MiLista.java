package com.frre.practica.tsp.programacionii.ejerciciolistas;

/**
 * Created by jvargas on 8/28/15.
 */
public class MiLista<T> {

    private Nodo<T> first;
    private Nodo<T> last;

    public void agregar(Nodo<T> nodo){
        if (nodo!=null){
            nodo.setSiguiente(first);
            if (first != null){
                first.setAnterior(nodo);
            }
            nodo.setAnterior(null);
            first = nodo;
            if (last == null){
                last = nodo;
            }
        }
    }

    public boolean remover(Nodo<T> nodo){
        if (nodo != null){
            Nodo<T> anterior = nodo.getAnterior();
            Nodo<T> siguiente = nodo.getSiguiente();

            if (first == nodo){
                first = siguiente;
            } else {
                anterior.setSiguiente(siguiente);
            }

            if (last == nodo){
                last = anterior;
            } else {
                siguiente.setAnterior(anterior);
            }

            return  true;
        }
        return false;
    }

    public boolean remover(int pos){
        Nodo<T> currentNodo = first;
        int currentPos = 0;
        while (currentNodo != null && currentPos != pos){
            currentNodo = currentNodo.getSiguiente();
            currentPos++;
        }
        if (currentNodo!=null){
            return remover(currentNodo);
        }
        return false;
    }

    public int longitud(){

        Nodo<T> currentNodo = first;
        int currentPos = 0;
        while (currentNodo != null){
            currentNodo = currentNodo.getSiguiente();
            currentPos++;
        }
        return currentPos;
    }

    public Nodo<T> obtenerEn(int pos){
        Nodo<T> currentNodo = first;
        int currentPos = 0;
        while (currentNodo != null && currentPos != pos){
            currentNodo = currentNodo.getSiguiente();
            currentPos++;
        }
        return currentNodo;
    }

}
