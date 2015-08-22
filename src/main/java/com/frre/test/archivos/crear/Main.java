package com.frre.test.archivos.crear;

import com.frre.programacion.Generador;
import com.frre.test.archivos.Auto;

import java.io.File;

import static com.frre.programacion.archivos.FuncionesDeArchivos.*;
/**
 * Created by jvargas on 8/20/15.
 */
public class Main {


    //ambiente
    //archivo
    private static File archivo;
    //registro
    private static Auto nuevoAuto;

    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        archivo = abrir("autosProvinciales", true);
        //agregamos 500 registros;
        for (int i = 0; i < 500; i++) {
            nuevoAuto = new Auto();
            nuevoAuto.setLocalidad(Generador.generarLocalidadAleatorio());
            nuevoAuto.setPatente(Generador.generarPalabraSinArticuloAleatoria());
            String nombre = Generador.generarNombreAleatorio()+","+Generador.generarApellidoAleatorio();
            nuevoAuto.setPropietario(nombre);
            nuevoAuto.setModelo(Generador.generarEnteroAleatorio(1987, 2015));

            grabar(archivo, nuevoAuto);
        }

        cerrar(archivo);
    }
}
