package com.frre.test.archivos.algoritmos.indexados;

import com.frre.programacion.archivos.GeneradorArchivos;
import com.frre.test.archivos.algoritmos.Bono;
import com.frre.test.archivos.algoritmos.Empleado;

import java.io.File;

import static com.frre.programacion.archivos.FuncionesDeArchivos.*;

/**
 * Created by jvargas on 8/20/15.
 */
public class Main {

    //ambiente

    //acumuladores
    static String resguardoSucursal;
    static String resguardoPcia;

    //registros
    static Empleado registro;

    //acums
    static double acumSucursal;
    static double acumTotal;
    static double acumPcia;

    //archivo
    private static File archivo;

    //bonos
    private static Bono bonos;
    private static File archivoIndexado;


    //algoritmo
    public static void main(String[] args){
        //muestra de funciones con archivos
        //aqui creamos un archivo
        registro = new Empleado();

        bonos = new Bono();

        GeneradorArchivos.generarArchivo("empleados", registro, 2000);

        GeneradorArchivos.generarArchivo("consumos", bonos, 2000);

        //con mi archivo creado cmoienzo a utilizarlo
        archivo = abrir("empleados");
        archivoIndexado = abrir("consumos");

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

            //cargo mi indexado
            bonos = new Bono();
            bonos.setProvincia(registro.getProvincia());
            bonos = leerIndexado(archivoIndexado, bonos);

            double acum = 0;
            if (bonos!=null){
                acum = bonos.getBono();
            }
            acumSucursal += registro.getSueldo() + acum;
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