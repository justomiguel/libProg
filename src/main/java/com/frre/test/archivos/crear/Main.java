package com.frre.test.archivos.crear;

import com.frre.programacion.Generador;
import com.frre.test.archivos.Alumno;

import java.io.File;

import static com.frre.programacion.archivos.FuncionesDeArchivos.*;
/**
 * Created by jvargas on 8/20/15.
 */
public class Main {


    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        File archivo = abrir("alumnos", true);
        //agregamos 500 registros;
        for (int i = 0; i < 500; i++) {
            Alumno nuevoALumno = new Alumno();
            nuevoALumno.setNomYApell(Generador.generarNombreAleatorio());
            nuevoALumno.setLegajo(Generador.generarEnteroAleatorio(19000, 25000));
            nuevoALumno.setDni(Generador.generarDNIAleatorio());
            nuevoALumno.setPromedio(Generador.generarEnteroAleatorio(7, 9)+1.2);
            grabar(archivo, nuevoALumno);
        }

        cerrar(archivo);
    }
}
