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

    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo

        Empleado pp = new Empleado();

        GeneradorArchivos.generarArchivo("empleados", pp, 2000, 3);

        //con mi archivo crado cmoienzo a utilizarlo
        File archivo = abrir("empleados");
        resguardo = 0;
        pp = leer(archivo, pp);
        nombreEmpleado = pp.getNombre();
        while (!FDA(archivo)){
            if (!nombreEmpleado.equalsIgnoreCase(pp.getNombre())){
                corteEmpleado(pp);
            }
            resguardo+=pp.getSueldo();
            pp = leer(archivo, pp);
        }

        cerrar(archivo);
    }

    private static void corteEmpleado(Empleado pp) {
        System.out.println("El sueldo total de la sucursal es "+resguardo);
        resguardo = 0;
        nombreEmpleado = pp.getNombre();
    }
}
