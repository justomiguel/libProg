package com.frre.test.archivos.lectura;

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
        File archivo = abrir("/home/jvargas/empleados");
        Empleado pp = new Empleado();

        while (!FDA(archivo)){
            pp = leer(archivo, pp);
            System.out.println(pp);
        }

        cerrar(archivo);
    }
}
