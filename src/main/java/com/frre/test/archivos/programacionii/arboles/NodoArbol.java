package com.frre.test.archivos.programacionii.arboles;

/**
 * Created by jvargas on 8/28/15.
 */
public class NodoArbol<T> {

    private T value;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    @Override
    public String toString() {
        return "NodoArbol{" +
                "value=" + value +
                '}';
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
