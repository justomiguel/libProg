/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Cleo
 */
public class EscritorDeArchivos {

    
    private File myFile;
    private ArrayList<String> lines;

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

    protected void writeIntoFileContents() {
        StringBuilder builder = new StringBuilder();
        for (String lineas : lines) {
            builder.append(lineas);
            builder.append(Constants.NEW_LINE);
        }
        String contents = builder.toString();
        FileWriter fw = null;
        try {
            fw = new FileWriter(myFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contents);
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Utils.handleException(ex);
        }
    }
}
