package com.frre.practica.tsp.programacioni.archivos.crear;

import static com.frre.library.Generador.*;

import com.frre.practica.tsp.programacioni.archivos.Empleado;

import java.io.File;

import static com.frre.library.archivos.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public final class Main {


    //ambiente
    //archivo
    private static File archivo;
    //registro
    private static Empleado nuevoUsuario;

    private Main() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        archivo = abrir("Musimundo", true);
        //agregamos 500 registros;

        for (int i = 0; i < 500; i++) {
            nuevoUsuario = new Empleado();
            nuevoUsuario.setNombre(generarNombreAleatorio());
            nuevoUsuario.setDni(generarDNIAleatorio());
            nuevoUsuario.setZona(generarEnteroAleatorio(0,10));
            nuevoUsuario.setEdad(generarEnteroAleatorio(15, 99));
            nuevoUsuario.setSucursal(generarEnteroAleatorio(0,15));
            nuevoUsuario.setSueldo(generarDecimalAleatorio(1,10));
            grabar(archivo, nuevoUsuario);
        }

        cerrar(archivo);
    }
}
