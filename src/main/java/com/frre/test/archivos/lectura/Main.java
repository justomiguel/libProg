package com.frre.test.archivos.lectura;

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
        File archivo = abrir("/home/jvargas/alumn");
        Alumno pp = new Alumno();
        pp = leer(archivo, pp);
        while (!FDA(archivo)){
            System.out.println(pp);
            pp = leer(archivo, pp);

        }

        cerrar(archivo);
    }
}
