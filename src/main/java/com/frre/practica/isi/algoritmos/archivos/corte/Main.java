package com.frre.practica.isi.algoritmos.archivos.corte;

import com.frre.practica.isi.algoritmos.archivos.Empleado;
import com.frre.library.archivos.GeneradorArchivos;
import static com.frre.library.archivos.FuncionesDeArchivos.*;

import java.io.File;

/**
 * Created by jvargas on 8/20/15.
 */
public final class Main {

    //ambiente

    //acumuladores
    private static String resguardoSucursal;
    private static String resguardoPcia;

    //registros
    private static Empleado registro;

    //acums
    private static double acumSucursal;
    private static double acumTotal;
    private static double acumPcia;

    //archivo
    private static File archivo;

    private Main() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        registro = new Empleado();

        GeneradorArchivos.generarArchivo("empleados", registro, 2000);
        //con mi archivo creado cmoienzo a utilizarlo
        archivo = abrir("empleados");
        registro = leer(archivo, registro);

        //resguardo de variables y seteo de acumuladores
        acumSucursal = 0;
        acumPcia = 0;
        acumTotal = 0;
        resguardoSucursal = registro.getLocalidad();
        resguardoPcia = registro.getProvincia();

        System.out.println("**************************************************************");
        System.out.println("Provincia "+resguardoPcia);
        System.out.println("**************************************************************");
        System.out.println("   Sucursal "+resguardoSucursal);
        while (!FDA(archivo)){
            if (!resguardoPcia.equalsIgnoreCase(registro.getProvincia())){
                corteProvincia();
            } else if (!resguardoSucursal.equalsIgnoreCase(registro.getLocalidad())){
                corteSucursal();
            }
            acumSucursal += registro.getSueldo();
            registro = leer(archivo, registro);
        }
        corteProvincia();
        totalGeneral();
        cerrar(archivo);
    }

    private static void corteProvincia() {
        corteSucursal();
        System.out.println("  El sueldo total de la provincia es " + acumPcia);
        acumTotal = acumTotal + acumPcia;
        acumPcia = 0;
        if (!FDA(archivo)){
            resguardoPcia = registro.getProvincia();
            System.out.println("**************************************************************");
            System.out.println("Provincia "+resguardoPcia);
            System.out.println("**************************************************************");
            System.out.println("   Sucursal "+resguardoSucursal);
        }
    }

    private static void corteSucursal() {
        System.out.println("        El sueldo total de la sucursal es "+ acumSucursal);
        acumPcia = acumPcia + acumSucursal;
        acumSucursal = 0;
        if (!FDA(archivo)){
            resguardoSucursal = registro.getLocalidad();
            if (resguardoPcia.equalsIgnoreCase(registro.getProvincia())){
                System.out.println("   Sucursal "+resguardoSucursal);
            }
        }
    }

    private static void totalGeneral() {
        System.out.println("El sueldo total del pais es "+ acumTotal);
    }
}