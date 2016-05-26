package com.frre.practica.tsp.programacioni.arreglos;

import com.frre.library.Generador;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by justo on 02/05/16.
 */
public class Main {

    public static void main(String[] args){
        //se define un numero para el arreglo
        int SIZE = 3;

        //Se crea un arreglo de Personas
        Persona[] personas = new Persona[SIZE];


            int sizeSobreNombres = Generador.generarEnteroAleatorio(0,100);
            //cargo el arreglo
            for (int j = 0; j < sizeSobreNombres; j++) {
                 System.out.print(Generador.generarPalabraSinArticuloAleatoria());
                int blancos = Generador.generarEnteroAleatorio(0,15);
                for (int i = 0; i < blancos; i++) {
                    System.out.print(" ");
                }
            }


    }
}
