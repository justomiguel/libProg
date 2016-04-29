package com.frre.practica.tsp.labii;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jvargas on 8/21/15.
 */
public class RegistrationSystem {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cantString = scanner.nextInt();

        HashMap<String, Integer> mapaValores = new HashMap<String, Integer>();

        for (int i = 0; i < cantString; i++) {
            String actual = scanner.next();

            Integer cantOcurrencias = mapaValores.get(actual);
            if (cantOcurrencias == null){
                System.out.println("OK");
                mapaValores.put(actual, 1);
            } else {
                System.out.println(actual+cantOcurrencias);
                cantOcurrencias+=1;
                mapaValores.put(actual, cantOcurrencias);
            }
        }
    }
}
