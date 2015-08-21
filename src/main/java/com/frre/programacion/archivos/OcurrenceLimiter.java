package com.frre.programacion.archivos;

import java.util.ArrayList;

/**
 * Created by jvargas on 8/21/15.
 */
public class OcurrenceLimiter {

    private Class<?> type;
    private int size;
    private ArrayList<Object> listaValores;

    public OcurrenceLimiter(int size, Class<?> type) {
        this.size = size;
        this.type = type;
        this.listaValores = new ArrayList<Object>(size);
    }

    public int getSize() {
        return size;
    }

    public boolean contains(Object o) {
        return listaValores.contains(o);
    }

    public int indexOf(Object o) {
        return listaValores.indexOf(o);
    }

    public boolean isEmpty() {
        return listaValores.isEmpty();
    }

    public Object get(int index) {
        return listaValores.get(index);
    }

    public boolean add(Object obj) {
        return listaValores.add(obj);
    }

    public void add(int index, Class<?> element) {
        listaValores.add(index, element);
    }
}
