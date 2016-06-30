package com.frre.library.archivos;

import com.frre.library.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import static com.frre.library.data.Constants.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author developer
 */
public final class FuncionesDeArchivos {

    private static HashMap<File, LectorArchivos> myArchs;
    private static HashMap<File, EscritorDeArchivos> myWrittenArchs;

    static {
        myArchs = new HashMap<File, LectorArchivos>();
        myWrittenArchs = new HashMap<File, EscritorDeArchivos>();
    }

    private FuncionesDeArchivos() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static File abrir(String string) {
        File arch = new File(string);
        if (!arch.exists()) {
            System.out.println(ARCHIVO_NO_EXISTE);
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
                        throw new IOException(SIN_PERMISOS_PARA_CREAR_ARCHIVOS);
                    }
                } catch (IOException ex) {
                    System.out.println(ARCHIVO__NO_PUEDE_CREARSE_ + ex.getClass().getName() + ex.getMessage());
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
            l.setRegistro(reg);
            l.recordToFile(reg);
        } else {
            System.out.println(NO_SE_PUEDE_GRABAR_EN_UN_ARCHIVO_NO_CREAD);
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

    public static <T> T leerIndexado(File archivo, T registro) {
        LectorArchivos l = myArchs.get(archivo);
        if (l != null) {
            registro = (T) l.getNextRecordIndexed(registro);
            return registro;
        }
        return null;
    }

    public static boolean FDA(File archivo) {
        LectorArchivos l = myArchs.get(archivo);
        if (l == null) {
            System.out.println(ARCHIVO_NO_EXISTE);
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
                    tle.writeIntoFileContents(tle.getRegistro());
                    myWrittenArchs.remove(archivo);
                } else {
                    System.out.println(ARCHIVO_YA_CERRADO);
                }
            }
        } else {
            System.out.println(IMPOSIBLE_CERRAR_UN_ARCHIVO_QUE_NO_SE_ABR);
        }
    }
}
