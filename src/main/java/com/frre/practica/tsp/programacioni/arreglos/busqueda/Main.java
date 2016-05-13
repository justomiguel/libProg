package com.frre.practica.tsp.programacioni.arreglos.busqueda;

import java.util.Arrays;

/**
 * Created by justo on 12/05/16.
 */
public class Main {

    public static void main(String[] args){
        int[] arreglo = {7,51,1,12,34,1,23,45,67};
        String[] nombres = {"Jose","Luis","Zapata","Hector"};

        //busqueda lineal
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == 1){
                System.out.println("Encontrado en pos "+i);
            }
        }

        //lineal con centinela
        int i = 0;
        while (i < arreglo.length && arreglo[i] != 1){
            i++;
        }
        if(i < arreglo.length){
            System.out.println(arreglo[i]+" encontrado en la pos "+i);
        }

        //lineal con centinela con for
        for (i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == 1){
                System.out.println("Encontrado en pos "+i);
                break;
            }
        }
        
        Arrays.sort(arreglo);

        int pos = Arrays.binarySearch(arreglo, 23);

        System.out.println(pos);

    }
}
