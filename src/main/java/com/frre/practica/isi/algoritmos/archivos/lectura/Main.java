package com.frre.practica.isi.algoritmos.archivos.lectura;

        import com.frre.practica.isi.algoritmos.archivos.Cliente;
        import static com.frre.library.archivos.FuncionesDeArchivos.*;

        import java.io.File;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {

    public static void main(String[] args){
        //muestra de funciones con archivos
        File archivo = abrir("/home/jvargas/clientes");
        Cliente pp = new Cliente();
        pp = leer(archivo, pp);
        while (!FDA(archivo)){
            System.out.println(pp);
            pp = leer(archivo, pp);
        }
        cerrar(archivo);
    }
}
