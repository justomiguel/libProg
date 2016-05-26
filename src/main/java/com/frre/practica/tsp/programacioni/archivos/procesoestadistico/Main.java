package com.frre.practica.tsp.programacioni.archivos.procesoestadistico;

import com.frre.practica.tsp.programacioni.archivos.Empleado;

import java.io.File;

import static com.frre.library.archivos.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {

    public static void main(String[] args){
        //muestra de funciones con archivos
        File archivo = abrir("Musimundo");

        Empleado pp = new Empleado();

        pp = leer(archivo, pp);

        double[][] matrizTotales = new double[17][12];

        while (!FDA(archivo)){

            int i = pp.getSucursal();
            int j = pp.getZona();

            matrizTotales[i][j] = matrizTotales[i][j] + pp.getSueldo();
            matrizTotales[16][j] = matrizTotales[16][j] + pp.getSueldo();
            matrizTotales[i][11] = matrizTotales[i][11] + pp.getSueldo();
            matrizTotales[16][11] = matrizTotales[16][11] + pp.getSueldo();

            pp = leer(archivo, pp);

        }

        System.out.print("     Zona ");
        for (int i = 0; i < 12; i++) {
            if (i != 11){
                System.out.print(i+" - ");
            } else {
                System.out.print("Total Zona");
            }
        }

        System.out.println("");
        for (int i = 0; i < 17; i++) {
            System.out.print("Sucursal "+i+" |");
            for (int j = 0; j < 12; j++) {
                Double d = matrizTotales[i][j];
                System.out.print(d.intValue()+" | ");
            }
            System.out.println("");
        }

        cerrar(archivo);
    }
}
