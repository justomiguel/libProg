package com.frre.test.archivos.programacionii;

/**
 * Created by jvargas on 8/21/15.
 */
public class Nodo {

    private String valor;
    private Nodo next;
    private Nodo before;

    @Override
    public String toString() {
        return "Nodo{" +
                "valor='" + valor + '\'' +
                '}';
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
