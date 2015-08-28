package com.frre.test.archivos.programacionii.ejerciciolistas;

/**
 * Created by jvargas on 8/28/15.
 */
public class  Nodo<T>{

    private T value;
    private Nodo siguiente;
    private Nodo anterior;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nodo)) return false;

        Nodo<?> nodo = (Nodo<?>) o;

        return !(getValue() != null ? !getValue().equals(nodo.getValue()) : nodo.getValue() != null);

    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
