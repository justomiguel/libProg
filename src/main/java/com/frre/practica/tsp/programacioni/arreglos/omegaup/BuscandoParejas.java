package com.frre.practica.tsp.programacioni.arreglos.omegaup;

/**
 * Created by justo on 19/05/16.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BuscandoParejas {

//ambiente

    //algoritmo
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cantHombres = sc.nextInt();
        int cantMujeres = sc.nextInt();

        Integer[] hombres = new Integer[cantHombres];
        int[] mujeres = new int[cantMujeres];

        if (cantHombres <= cantMujeres){
            System.out.println("No hay solteros");
        } else {

            for (int i = 0; i < cantHombres; i++) {
                hombres[i] = sc.nextInt();
            }
            for (int i = 0; i < cantMujeres; i++) {
                mujeres[i] = sc.nextInt();
            }

            Arrays.sort(hombres, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2)*-1;
                }
            });


            System.out.println(Math.abs((cantMujeres - cantHombres)) + " " + hombres[cantHombres-1]);

        }

    }
}