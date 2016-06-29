/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.library.archivos;

import com.frre.library.Clave;
import com.frre.library.Utils;
import com.frre.library.data.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 *
 * @author Cleo
 */
public class EscritorDeArchivos {


    private final File myFile;
    private final ArrayList<String> lines;
    private Object registro;

    public Object getRegistro() {
        return registro;
    }

    public void setRegistro(Object registro) {
        this.registro = registro;
    }

    public EscritorDeArchivos(File myFile) {
        this.myFile = myFile;
        lines = new ArrayList<String>();
    }

    public <T> void recordToFile(T reg) {
        StringBuilder builder = new StringBuilder();
        for (Field f : reg.getClass().getDeclaredFields()) {
            try {
                Method method = reg.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                Object results = method.invoke(reg);
                if (results.getClass().isAssignableFrom(Date.class)) {
                    results = formatDate(results);
                }
                builder.append(results);
                builder.append(Constants.FIELD_SEPARATOR);
            } catch (Exception ex) {
                Utils.handleException(ex);
            }
        }
        String lineToSave = builder.toString().substring(0, builder.length() - 1);
        //    System.out.println(lineToSave);
        lines.add(lineToSave);
    }

    private void writeIntoFile(String substring) {
        StringBuilder myString = new StringBuilder();
        for (String lineas : lines) {
            myString.append(lineas);
            myString.append(Constants.NEW_LINE);
        }
    }

    private Object formatDate(Object results) {
        StringBuilder builderInternal = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) results);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        builderInternal.append(Constants.SPACE);
        builderInternal.append(day);
        builderInternal.append(Constants.DATE_SEPARATOR);
        builderInternal.append(month);
        builderInternal.append(Constants.DATE_SEPARATOR);
        builderInternal.append(year);
        builderInternal.append(Constants.SPACE);
        return builderInternal;
    }

    protected void writeIntoFileContents(Object registro) {
        try {


            int cantClaves = 0;

            ArrayList<Object> theContents = new ArrayList<Object>();
            for (String currentLine : lines) {
                String[] fields = currentLine.split(Constants.FIELD_SEPARATOR);
                Object localReg = (Object) registro.getClass().newInstance();
                int currentFieldNumber = 0;
                for (Field f : registro.getClass().getDeclaredFields()) {
                    Method method = localReg.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());
                    method.invoke(localReg, Utils.tranformAccordingType(f.getType(), fields[currentFieldNumber]));
                    currentFieldNumber++;
                    if (f.getAnnotation(Clave.class)!=null){
                        cantClaves+=1;
                    }
                }
                theContents.add(localReg);
            }

            if (cantClaves > 0){
                final int claves = cantClaves;
                Collections.sort(theContents, new Comparator<Object>() {
                    @Override
                    public int compare(Object obj1, Object obj2) {
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




            StringBuilder finalBuilder = new StringBuilder();
            for (Object lineas : theContents) {

                StringBuilder builder = new StringBuilder();
                for (Field f : lineas.getClass().getDeclaredFields()) {
                    try {
                        Method method = lineas.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                        Object results = method.invoke(lineas);
                        if (results.getClass().isAssignableFrom(Date.class)) {
                            results = formatDate(results);
                        }
                        builder.append(results);
                        builder.append(Constants.FIELD_SEPARATOR);
                    } catch (Exception ex) {
                        Utils.handleException(ex);
                    }
                }
                String lineToSave = builder.toString().substring(0, builder.length() - 1);
                finalBuilder.append(lineToSave);
                finalBuilder.append(Constants.NEW_LINE);
            }

            String contents = finalBuilder.toString();
            FileWriter fw = null;

            fw = new FileWriter(myFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contents);
            bw.close();
            fw.close();
        } catch (Exception ex) {
            Utils.handleException(ex);
        }
    }
}
