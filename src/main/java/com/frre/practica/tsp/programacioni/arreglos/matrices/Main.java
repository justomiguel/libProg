package com.frre.practica.tsp.programacioni.arreglos.matrices;

/**
 * Created by justo on 26/05/16.
 */
public final class Main {

    private Main() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static void main(String[] args){
        int[][] matriz = new int[4][4];

        int cont = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = cont;
                cont++;
            }
        }

        //recorro la matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
