package com.frre.practica.tsp.programacioni.archivos.lectura;

import com.frre.practica.tsp.programacioni.archivos.Cliente;
import com.frre.practica.tsp.programacioni.archivos.Usuario;

import java.io.File;

import static com.frre.library.archivos.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {

    public static void main(String[] args){
        //muestra de funciones con archivos
        File archivo = abrir("usuarios");
        Usuario pp = new Usuario();
        pp = leer(archivo, pp);
        while (!FDA(archivo)){
            System.out.println(pp);
            pp = leer(archivo, pp);
        }
        cerrar(archivo);
    }
}
