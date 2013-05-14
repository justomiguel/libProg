/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Cleo
 */
public class Utils {

    public static <T> T tranformAccordingType(Class<T> type, String string) {

        if (type.isAssignableFrom(String.class)) {
            return (T) string;
        } else if (type.isAssignableFrom(Date.class)) {
            String[] date = string.split("/");
            int year = Integer.parseInt(date[2].trim());
            int month = Integer.parseInt(date[1].trim());
            int day = Integer.parseInt(date[0].trim());
            Date d;
            Calendar cal = GregorianCalendar.getInstance();
            cal.set( year, month, day);
            d = cal.getTime();
            return (T) d;
        } else if (type.isAssignableFrom(Fecha.class)) {
            return (T) new Fecha(string.trim());
        } else if (type.isAssignableFrom(double.class) || (type.isAssignableFrom(Double.class))) {
            return (T) new Double(string.trim().replaceAll(",", "."));
        } else if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class)) {
            return (T) new Double(string.trim().replaceAll(",", "."));
        } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            //takeout all spaces
            return (T) new Integer(string.trim());
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

    public static String getSetMethod(String fieldName) {
        // TODO Auto-generated method stub
        String firstWithCapitalLetter = fieldName.toUpperCase().substring(0, 1);
        String restOfMethodName = fieldName.substring(1, fieldName.length());
        return "set" + firstWithCapitalLetter + restOfMethodName;
    }
    
    public static String getGetMethod(String fieldName) {
        // TODO Auto-generated method stub
        String firstWithCapitalLetter = fieldName.toUpperCase().substring(0, 1);
        String restOfMethodName = fieldName.substring(1, fieldName.length());
        String methodName = "get" + firstWithCapitalLetter + restOfMethodName;
        return methodName;
    }

    static void handleException(Exception ex) {
        System.out.println("Excepcion ocurrida " + ex.getClass().getName()+" "+ex.getMessage());
    }
}
