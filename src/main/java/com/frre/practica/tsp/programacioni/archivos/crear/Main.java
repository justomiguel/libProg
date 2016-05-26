package com.frre.practica.tsp.programacioni.archivos.crear;

import static com.frre.library.Generador.*;
import com.frre.practica.tsp.programacioni.archivos.Usuario;

import java.io.File;

import static com.frre.library.archivos.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {


    //ambiente
    //archivo
    private static File archivo;
    //registro
    private static Usuario nuevoUsuario;

    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        archivo = abrir("Musimundo", true);
        //agregamos 500 registros;
        for (int i = 0; i < 500; i++) {
            nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(generarNombreAleatorio());
            nuevoUsuario.setDni(generarDNIAleatorio());
            nuevoUsuario.setDomicilio(generarLocalidadAleatorio());
            nuevoUsuario.setEdad(generarEnteroAleatorio(15, 99));

            grabar(archivo, nuevoUsuario);
        }

        cerrar(archivo);
    }
}
