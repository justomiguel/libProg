package com.frre.practica.tsp.programacioni.arreglos;

import com.frre.library.Generador;

/**
 * Created by justo on 02/05/16.
 */
public class Main {

    public static void main(String[] args){
        //se define un numero para el arreglo
        int SIZE = 50;

        //Se crea un arreglo de Personas
        Persona[] personas = new Persona[SIZE];

        for (int i = 0; i < SIZE; i++) {
            //creo el arreglo de sobreNombres
            int sizeSobreNombres = Generador.generarEnteroAleatorio(0,10);
            String[] arregloDeSobreNombres = new String[sizeSobreNombres];

            //cargo el arreglo
            for (int j = 0; j < sizeSobreNombres; j++) {
                arregloDeSobreNombres[j] = Generador.generarPalabraSinArticuloAleatoria();
            }

            //creo la persona
            Persona persona = new Persona(Generador.generarNombreAleatorio(), Generador.generarLegajoAleatorio(), arregloDeSobreNombres);
            personas[i] = persona;

        }

        //recorroo el arreglo original y lo muestro
        for (int i = 0; i < SIZE; i++) {
            System.out.println(personas[i]);
        }

    }
}
