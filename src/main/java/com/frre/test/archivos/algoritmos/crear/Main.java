package com.frre.test.archivos.algoritmos.crear;

import com.frre.programacion.Generador;
import com.frre.test.archivos.algoritmos.Auto;
import com.frre.test.archivos.algoritmos.Cliente;
import com.frre.test.archivos.algoritmos.Usuario;

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
    private static Usuario nuevoUsuario;

    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        archivo = abrir("usuarios", true);
        //agregamos 500 registros;
        for (int i = 0; i < 500; i++) {
            nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(Generador.generarNombreAleatorio());
            nuevoUsuario.setDni(Generador.generarDNIAleatorio());
            nuevoUsuario.setDomicilio(Generador.generarLocalidadAleatorio());
            nuevoUsuario.setEdad(Generador.generarEnteroAleatorio(15, 99));

            grabar(archivo, nuevoUsuario);
        }

        cerrar(archivo);
    }
}
