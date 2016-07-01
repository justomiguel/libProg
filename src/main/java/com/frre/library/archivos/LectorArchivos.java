/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.library.archivos;

import com.frre.library.Clave;
import com.frre.library.data.Constants;
import com.frre.library.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author developer
 */
public class LectorArchivos<T> {
   

    private final File myFile;
    private int currentCounter;
    private ArrayList<String> lines;
    private ArrayList<Object> theContents;
    private Object registro;

    public LectorArchivos(File myFile, String name) {
        this.myFile = myFile;
        currentCounter = 0;
    }

    public <T> void getContents(T registro) {

        this.registro = registro;

        theContents = (ArrayList<Object>) new ArrayList<T>();
        try {
            //use buffering, reading one line at a time
            FileInputStream fis = new FileInputStream(myFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader input = new BufferedReader(inputStreamReader);
            lines = new ArrayList<String>();
            try {
                String line; //not declared within while loop

                while ((line = input.readLine()) != null) {
                    if (!line.startsWith(Constants.COMMENTED_LINE) && line.length() >= 1) {
                        lines.add(line);
                    }
                }

                for (String currentLine : lines) {
                    String[] fields = currentLine.split(Constants.FIELD_SEPARATOR);
                    T localReg = (T) registro.getClass().newInstance();
                    int currentFieldNumber = 0;
                    for (Field f : registro.getClass().getDeclaredFields()) {
                        Method method = localReg.getClass().getDeclaredMethod(Utils.getSetMethod(f.getName()), f.getType());
                        method.invoke(localReg, Utils.tranformAccordingType(f.getType(), fields[currentFieldNumber]));
                        currentFieldNumber++;
                    }
                    theContents.add(localReg);
                }

            } finally {
                input.close();
                fis.close();
            }
        } catch (Exception ex) {
            Utils.handleException(ex);
        }

    }

    public Object getRegistro() {
        return registro;
    }

    public <T> T getNextRecord(T registro) {

        if (currentCounter == 0) {
            getContents(registro);
        }
        if (currentCounter < theContents.size()) {
            T localVar = (T) theContents.get(currentCounter);
            currentCounter++;
            return localVar;
        }
        currentCounter++;
        return null;

    }
   
    public boolean FDA() {
        int value = (theContents == null) ? 0 : theContents.size();
        return currentCounter > (value);
    }

    void dispose() {
        throw new UnsupportedOperationException(Constants.NOT_SUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> T getNextRecordIndexed(T registro) {
        getContents(registro);
        try {
            for (Object object : theContents){
                for (Field f : object.getClass().getDeclaredFields()) {
                    Method method = object.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                    Object value = method.invoke(object);

                    //en el host
                    Method method2 = registro.getClass().getDeclaredMethod(Utils.getGetMethod(f.getName()));
                    Object value2 = method.invoke(registro);
                    if (f.getAnnotation(Clave.class)!=null){
                        if (value.equals(value2)){
                            return (T) object;
                        }
                    }
                }
            }
        } catch (Exception e){

        }
        return null;
    }
}
