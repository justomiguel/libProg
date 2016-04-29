package com.frre.practica.tsp.programacionii.arboles;

/**
 * Created by jvargas on 8/28/15.
 */
public class MainArboles {

    public static void main(String[] args){
        NodoArbol<Integer> nodo4 = new NodoArbol<Integer>();
        nodo4.setValue(4);

        NodoArbol<Integer> nodo3 = new NodoArbol<Integer>();
        nodo3.setValue(3);
        nodo3.setHijoIzquierdo(nodo4);

        NodoArbol<Integer> nodo7 = new NodoArbol<Integer>();
        nodo7.setValue(7);

        NodoArbol<Integer> nodo31 = new NodoArbol<Integer>();
        nodo31.setValue(31);
        nodo31.setHijoDerecho(nodo7);

        NodoArbol<Integer> nodo2 = new NodoArbol<Integer>();
        nodo2.setValue(2);
        nodo2.setHijoIzquierdo(nodo3);
        nodo2.setHijoDerecho(nodo31);

        preOrden(nodo2);
        enOrden(nodo2);
        postOrden(nodo2);

        System.out.println(sumatoria(nodo2));
    }

    private static int sumatoria(NodoArbol<Integer> nodo) {
        if (nodo == null){
            return 0;
        }
        Integer value = nodo.getValue();
        return value+
                sumatoria(nodo.getHijoIzquierdo())
                +sumatoria(nodo.getHijoDerecho());
    }

    private static void postOrden(NodoArbol<Integer> nodo) {
        if (nodo != null){
            postOrden(nodo.getHijoIzquierdo());
            postOrden(nodo.getHijoDerecho());
            System.out.println(nodo);

        }
    }

    private static void enOrden(NodoArbol<Integer> nodo) {
        if (nodo != null){
            enOrden(nodo.getHijoIzquierdo());
            System.out.println(nodo);
            enOrden(nodo.getHijoDerecho());
        }
    }

    private static void preOrden(NodoArbol<Integer> nodo) {
        if (nodo != null){
            System.out.println(nodo);
            preOrden(nodo.getHijoIzquierdo());
            preOrden(nodo.getHijoDerecho());
        }
    }


}
