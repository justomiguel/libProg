package com.frre.programacion;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.frre.programacion.FuncionesDeArchivos.*;
/**
 * Created by jvargas on 8/20/15.
 */
public class GeneradorArchivos {

    public static <T> void generarArchivo(String nombreArchivo, T registro, int cantRegistros) {
        generarArchivo(nombreArchivo, registro, cantRegistros, 0);
    }

    public static <T> void generarArchivo(String nombreArchivo, T registro, int cantRegistros, final int cantClaves) {
        try{
            File archivo = abrir(nombreArchivo, true);
            ArrayList<T> registros = new ArrayList<T>();

            for (int i = 0; i < cantRegistros; i++) {
                T localReg = (T) registro.getClass().newInstance();
                Field[] campos = localReg.getClass().getDeclaredFields();
                for (int j = 0; j < campos.length; j++) {
                    Field f = campos[j];
                    Method method = localReg.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());
                    Class<?> tipo = f.getType();
                    method.invoke(localReg, Utils.getValueACcordingType(tipo));
                }
                registros.add(localReg);
            }
            if (cantClaves > 0){
                Collections.sort(registros, new Comparator<T>() {
                    @Override
                    public int compare(T obj1, T obj2) {
                        try {
                            Field[] campos = obj1.getClass().getDeclaredFields();
                            for (int i = 0; i < cantClaves; i++) {
                                Field f = campos[i];
                                Method method = obj1.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                                Method method2 = obj2.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                                Comparable comparable = (Comparable) method.invoke(obj1);
                                Comparable comparable2 = (Comparable) method2.invoke(obj2);
                                int comparation = comparable.compareTo(comparable2);
                                if (comparation != 0) {
                                    return comparation;
                                }
                            }
                            return 0;
                        } catch (Exception e) {

                        }
                        return 0;
                    }
                });
            }
            for(T theRegister:registros){
                grabar(archivo, theRegister);
            }
            cerrar(archivo);
        } catch (Exception ex) {
            Utils.handleException(ex);
        }
    }

}
