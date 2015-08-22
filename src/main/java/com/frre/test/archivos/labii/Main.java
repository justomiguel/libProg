package com.frre.test.archivos.labii;

import com.frre.programacion.Generador;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jvargas on 8/21/15.
 */
public class Main {

    public static void main(String[] args){
        Map<String, String> myMap = new HashMap<String, String>();

        for (int i = 0; i < 15; i++) {
            String clave = Generador.generarNombreAleatorio();
            String valor = Generador.generarLocalidadAleatorio();
            myMap.put(clave, valor);
        }

        Set<String> claves = myMap.keySet();
        for(String clave : claves){
            System.out.println(clave+":"+myMap.get(clave));
        }
    }
}
