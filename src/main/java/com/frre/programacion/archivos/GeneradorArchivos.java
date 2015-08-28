package com.frre.programacion.archivos;

import com.frre.programacion.Clave;
import com.frre.programacion.Generador;
import com.frre.programacion.Utils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by jvargas on 8/20/15.
 */
public class GeneradorArchivos {

    public static <T> void generarArchivo(String nombreArchivo, T registro, int cantRegistros) {
        try{
            File archivo = FuncionesDeArchivos.abrir(nombreArchivo, true);
            ArrayList<T> registros = new ArrayList<T>();

            //obtengo primero todos los valores
            Field[] campos = registro.getClass().getDeclaredFields();
            HashMap<Field, OcurrenceLimiter> valores = new HashMap<Field, OcurrenceLimiter>();
            for (int j = 0; j < campos.length; j++) {
                Field f = campos[j];
                int tope = 2*cantRegistros/100;
                int cantValores = Generador.generarEnteroAleatorio(1,tope == 0? cantRegistros : tope);
                if (f.getAnnotation(Clave.class)==null){
                    cantValores = cantRegistros;
                }
                OcurrenceLimiter ocurrenceLimiter = new OcurrenceLimiter(cantValores, f.getType());

                Method method = registro.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());

                for (int i = 0; i < cantValores; i++) {
                    ocurrenceLimiter.add(Utils.getValueAccordingTypeAndMethodName(f.getType(), method.getName()));
                }
                valores.put(f, ocurrenceLimiter);
            }

            int cantClaves = 0;

            for (int i = 0; i < cantRegistros; i++) {
                T localReg = (T) registro.getClass().newInstance();
                for (int j = 0; j < campos.length; j++) {
                    Field f = campos[j];
                    Method method = localReg.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());
                    Class<?> tipo = f.getType();
                    if (f.getAnnotation(Clave.class)!=null){
                        cantClaves+=1;
                    }
                    OcurrenceLimiter ocurrenceLimiter = valores.get(f);
                    int numero = Generador.generarEnteroAleatorio(0, ocurrenceLimiter.getSize() - 1);
                    method.invoke(localReg, ocurrenceLimiter.get(numero));
                }
                registros.add(localReg);
            }

            if (cantClaves > 0){
                final int claves = cantClaves;
                Collections.sort(registros, new Comparator<T>() {
                    @Override
                    public int compare(T obj1, T obj2) {
                        try {
                            Field[] campos = obj1.getClass().getDeclaredFields();
                            for (int i = 0; i < claves; i++) {
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
                FuncionesDeArchivos.grabar(archivo, theRegister);
            }
            FuncionesDeArchivos.cerrar(archivo);
        } catch (Exception ex) {
            Utils.handleException(ex);
        }
    }

    public static <T> void generarArchivo(String nombreArchivo, T registro, int cantRegistros, final int cantClaves) {
        try{
            File archivo = FuncionesDeArchivos.abrir(nombreArchivo, true);
            ArrayList<T> registros = new ArrayList<T>();

            //obtengo primero todos los valores
            Field[] campos = registro.getClass().getDeclaredFields();
            HashMap<Field, OcurrenceLimiter> valores = new HashMap<Field, OcurrenceLimiter>();
            for (int j = 0; j < campos.length; j++) {
                Field f = campos[j];
                int tope = 2*cantRegistros/100;
                int cantValores = Generador.generarEnteroAleatorio(1,tope == 0? cantRegistros : tope);
                OcurrenceLimiter ocurrenceLimiter = new OcurrenceLimiter(cantValores, f.getType());

                Method method = registro.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());

                for (int i = 0; i < cantValores; i++) {
                    ocurrenceLimiter.add(Utils.getValueAccordingTypeAndMethodName(f.getType(), method.getName()));
                }
                valores.put(f, ocurrenceLimiter);
            }

            for (int i = 0; i < cantRegistros; i++) {
                T localReg = (T) registro.getClass().newInstance();
                for (int j = 0; j < campos.length; j++) {
                    Field f = campos[j];
                    Method method = localReg.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());
                    Class<?> tipo = f.getType();
                    OcurrenceLimiter ocurrenceLimiter = valores.get(f);
                    int numero = Generador.generarEnteroAleatorio(0, ocurrenceLimiter.getSize()-1);
                    method.invoke(localReg, ocurrenceLimiter.get(numero));
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
                FuncionesDeArchivos.grabar(archivo, theRegister);
            }
            FuncionesDeArchivos.cerrar(archivo);
        } catch (Exception ex) {
            Utils.handleException(ex);
        }
    }

}
