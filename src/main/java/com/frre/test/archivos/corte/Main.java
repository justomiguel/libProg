package com.frre.test.archivos.corte;

import com.frre.programacion.GeneradorArchivos;
import com.frre.test.archivos.Empleado;

import java.io.File;

import static com.frre.programacion.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {

    private static double resguardo;
    private static String nombreEmpleado;
    private static Empleado registro;

    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo

        registro = new Empleado();

        GeneradorArchivos.generarArchivo("empleados", registro, 2000, 3);

        //con mi archivo crado cmoienzo a utilizarlo
        File archivo = abrir("empleados");
        resguardo = 0;
        registro = leer(archivo, registro);
        nombreEmpleado = registro.getNombre();
        while (!FDA(archivo)){
            if (!nombreEmpleado.equalsIgnoreCase(registro.getNombre())){
                corteEmpleado();
            }
            resguardo+= registro.getSueldo();
            registro = leer(archivo, registro);
        }
        corteEmpleado();
        cerrar(archivo);
    }

    private static void corteEmpleado() {
        System.out.println("El sueldo total de la sucursal es "+resguardo);
        resguardo = 0;
        if (registro!= null){
            nombreEmpleado = registro.getNombre();
        }
    }
}
