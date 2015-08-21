package com.frre.test.archivos.mezcla;

import com.frre.programacion.Generador;
import com.frre.programacion.Utils;
import com.frre.programacion.archivos.GeneradorArchivos;
import com.frre.test.archivos.Empleado;

import java.io.File;

import static com.frre.programacion.archivos.FuncionesDeArchivos.*;
import static com.frre.programacion.archivos.FuncionesDeArchivos.FDA;

/**
 * Created by jvargas on 8/21/15.
 */
public class Main {


    //ambiente

    //registros
    static Empleado registroPersonal;
    static Empleado registroPersonalExterno;

    //archivoPersonal
    private static File archivoPersonal;
    private static File archivoPersonalExterno;
    private static File archivoFinal;


    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivoPersonal
        registroPersonal = new Empleado();
        registroPersonalExterno = new Empleado();

        GeneradorArchivos.generarArchivo("personal", registroPersonal, Generador.generarEnteroAleatorio(100,1000), 2);
        GeneradorArchivos.generarArchivo("personalExterno", registroPersonalExterno, Generador.generarEnteroAleatorio(100,1000), 2);

        //con mi archivoPersonal creado cmoienzo a utilizarlo
        archivoPersonal = abrir("personal");
        archivoPersonalExterno = abrir("personalExterno");

        archivoFinal = abrir("nuevoPersonal", true);

        registroPersonal = leer(archivoPersonal, registroPersonal);
        registroPersonalExterno = leer(archivoPersonalExterno, registroPersonalExterno);

        while (!FDA(archivoPersonal) && !FDA(archivoPersonalExterno)){
            if (Utils.esMenor(registroPersonal.getProvincia(), registroPersonalExterno.getProvincia())){
                grabar(archivoFinal, registroPersonal);
                leer(archivoPersonal, registroPersonal);
            } else if (Utils.esMayor(registroPersonal.getProvincia(), registroPersonalExterno.getProvincia())){
                grabar(archivoFinal, registroPersonalExterno);
                leer(archivoPersonalExterno, registroPersonalExterno);
            }  else {
                grabar(archivoFinal, registroPersonalExterno);
                grabar(archivoFinal, registroPersonal);
                leer(archivoPersonalExterno, registroPersonalExterno);
                leer(archivoPersonal, registroPersonal);
            }
        }

        while (!FDA(archivoPersonal)){
            grabar(archivoFinal, registroPersonal);
            leer(archivoPersonal, registroPersonal);
        }

        while (!FDA(archivoPersonalExterno)){
            grabar(archivoFinal, registroPersonalExterno);
            leer(archivoPersonalExterno, registroPersonalExterno);
        }

        cerrar(archivoPersonalExterno);
        cerrar(archivoPersonal);
        cerrar(archivoFinal);
    }

}
