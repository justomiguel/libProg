package com.frre.practica.tsp.programacioni.arreglos.ordenamiento;

import java.util.Arrays;

/**
 * Created by justo on 12/05/16.
 */
public class Main {

    public static void main(String[] args){
        int[] arreglo = {7,51,1,12,34};
        String[] nombres = {"Jose","Luis","Zapata","Hector"};

        Arrays.sort(nombres);

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
    }
}
