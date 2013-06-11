/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.lang.reflect.Array;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author justomiguel
 */
public class Ordenar {

    public static <T> T[] intercambio(T[] vector, boolean direction) {
        for (int i = 1; i < vector.length; i++) {
            for (int j = 0; j < vector.length - 1; j++) {
                boolean mayor = getMayor(vector[j], vector[j + 1]) == 1 == direction;
                if (mayor) {
                    T temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
        return vector;
    }

    public static <T> T[] insercion(T[] vector, boolean direction) {
        for (int i = 1; i < vector.length; i++) {
            T temp = vector[i];
            int j;
            for (j = i - 1; j >= 0 && (getMayor(vector[j], temp) == 1 == direction); j--) {
                vector[j + 1] = vector[j];

            }

            vector[j + 1] = temp;
        }
        return vector;
    }

    public static <T> T[] seleccion(T[] matrix, boolean direction) {
        int i, j, k, p;
        T buffer;
        int limit = matrix.length - 1;
        for (k = 0; k < limit; k++) {
            p = k;
            for (i = k + 1; i <= limit; i++) {
                boolean mayor = (getMayor(matrix[p], matrix[i]) == 1 )== direction;
                if (mayor) {
                    p = i;
                }
            }

            if (p != k) {
                buffer = matrix[p];
                matrix[p] = matrix[k];
                matrix[k] = buffer;
            }
        }
        return matrix;
    }

    /*
     *   a negative integer, zero
     * or a positive integer as this 
     * object is less than, equal to, or greater than the specified object. 
     */
    private static <T> int getMayor(T elem, T otherElem) {
        Comparable elemC = (Comparable) elem;
        return elemC.compareTo(otherElem);
    }
}
