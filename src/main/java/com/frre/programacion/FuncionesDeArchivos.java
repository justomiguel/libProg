package com.frre.programacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author developer
 */
public class FuncionesDeArchivos {

    private static HashMap<File, LectorArchivos> myArchs;
    private static HashMap<File, EscritorDeArchivos> myWrittenArchs;

    static {
        myArchs = new HashMap<File, LectorArchivos>();
        myWrittenArchs = new HashMap<File, EscritorDeArchivos>();
    }

    public static File abrir(String string) {
        File arch = new File(string);
        if (!arch.exists()) {
            System.out.println("Archivo no existe");
        } else {
            LectorArchivos l = new LectorArchivos(arch, string);
            myArchs.put(arch, l);

        }
        return arch;
    }

    public static File abrir(String string, boolean createIfNotExists) {
        if (createIfNotExists) {
            File arch = new File(string);

            if (!arch.exists()) {
                try {
                    if (arch.createNewFile()) {
                        arch.setReadable(true);
                        arch.setWritable(true);
                    } else {
                        throw new IOException("Sin permisos para crear archivos");
                    }
                } catch (IOException ex) {
                    System.out.println("Archivo No puede crearse. " + ex.getClass().getName() + ex.getMessage());
                }
            }

            if (arch.exists()) {
                FileWriter fw = null;
                try {
                    fw = new FileWriter(arch.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("");
                    bw.close();
                    fw.close();
                    EscritorDeArchivos esc = new EscritorDeArchivos(arch);
                    myWrittenArchs.put(arch, esc);
                } catch (IOException ex) {
                    Utils.handleException(ex);
                }
            }

            return arch;
        } else {
            return abrir(string);
        }
    }

    public static <T> void grabar(File archS, T reg) {
        EscritorDeArchivos l = myWrittenArchs.get(archS);
        if (l != null) {
            l.recordToFile(reg);
        } else {
            System.out.println("No se puede grabar en un archivo no creado");
        }
    }

    public static <T> T leer(File archivo, T registro) {
        LectorArchivos l = myArchs.get(archivo);
        if (l != null) {
            registro = (T) l.getNextRecord(registro);
            return registro;
        }
        return null;
    }

    public static boolean FDA(File archivo) {
        LectorArchivos l = myArchs.get(archivo);
        if (l == null) {
            System.out.println("Archivo no existe");
        }
        return l.FDA();
    }

    public static void cerrar(File archivo) {
        if (archivo != null) {
            LectorArchivos l = myArchs.get(archivo);
            if (l != null) {
                //l.dispose();
                myArchs.remove(archivo);
            } else {
                EscritorDeArchivos tle = myWrittenArchs.get(archivo);
                if (tle != null) {
                    tle.writeIntoFileContents();
                    myWrittenArchs.remove(archivo);
                } else {
                    System.out.println("Archivo ya cerrado");
                }
            }
        } else {
            System.out.println("Imposible cerrar un archivo que no se abrio");
        }
    }
}
