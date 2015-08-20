package com.frre.test.archivos.crear;

import com.frre.programacion.Generador;
import com.frre.test.archivos.Empleado;

import java.io.File;

import static com.frre.programacion.FuncionesDeArchivos.*;
/**
 * Created by jvargas on 8/20/15.
 */
public class Main {


    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        File archivo = abrir("empleados", true);
        //agregamos 500 registros;
        for (int i = 0; i < 500; i++) {
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setApellido(Generador.generarApellidoAleatorio());
            nuevoEmpleado.setNombre(Generador.generarNombreAleatorio());
            nuevoEmpleado.setDni(Generador.generarDNIAleatorio());
            nuevoEmpleado.setSueldo(Generador.generarNumeroAleatorio(1000, 9000) * 1.5);

            grabar(archivo, nuevoEmpleado);
        }

        cerrar(archivo);
    }
}
