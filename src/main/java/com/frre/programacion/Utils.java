/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.frre.programacion.data.Constants;

/**
 *
 * @author Cleo
 */
public class Utils {
   

    public static <T> T tranformAccordingType(Class<T> type, String string) {

        if (type.isAssignableFrom(String.class)) {
            return (T) string;
        } else if (type.isAssignableFrom(Date.class)) {
            String[] date = string.split(Constants.DATE_SEPARATOR);
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
            return (T) new Double(string.trim().replaceAll(Constants.COMMA, Constants.DOT));
        } else if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class)) {
            return (T) new Float(string.trim().replaceAll(Constants.COMMA, Constants.DOT));
        } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            //takeout all spaces
            return (T) new Integer(string.trim());
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

    public static <T> T getValueACcordingType(Class<T> type) {

        if (type.isAssignableFrom(String.class)) {
            return (T) Generador.generarStringAleatorio();
        } else if (type.isAssignableFrom(Date.class)) {
            int year = Generador.generarEnteroAleatorio(1900, 2015);
            int month = Generador.generarEnteroAleatorio(1, 12);
            int day = Generador.generarEnteroAleatorio(1, 31);
            Date d;
            Calendar cal = GregorianCalendar.getInstance();
            cal.set( year, month, day);
            d = cal.getTime();
            return (T) d;
        } else if (type.isAssignableFrom(Fecha.class)) {
            int year = Generador.generarEnteroAleatorio(1900, 2015);
            int month = Generador.generarEnteroAleatorio(1, 12);
            int day = Generador.generarEnteroAleatorio(1, 31);
            Date d;
            Calendar cal = GregorianCalendar.getInstance();
            cal.set( year, month, day);
            d = cal.getTime();
            SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
            return (T) new Fecha(sm.format(d));
        } else if (type.isAssignableFrom(double.class) || (type.isAssignableFrom(Double.class))) {
            return (T) Generador.generarDecimalAleatorio(0,500);
        } else if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class)) {
            return (T) new Float(Generador.generarEnteroAleatorio(0, 500));
        } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            //takeout all spaces
            Integer integer = Generador.generarEnteroAleatorio(0, 500);
            return (T) integer;
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

    public static <T> T getValueAccordingTypeAndMethodName(Class<T> type, String methodName) {
        methodName = methodName.toLowerCase();
        if (type.isAssignableFrom(String.class)) {
            if (methodName.contains("nom") && methodName.contains("ap")){
                return (T) String.valueOf(Generador.generarNombreAleatorio()+","+Generador.generarApellidoAleatorio());
            } else if (methodName.contains("apellido")){
                return (T) Generador.generarApellidoAleatorio();
            } else if (methodName.contains("nombre")){
                return (T) Generador.generarNombreAleatorio();
            }  else if (methodName.contains("provincia") || methodName.contains("pcia")){
                return (T) Generador.generarPciaAleatorio();
            }  else if (methodName.contains("pais") || methodName.contains("country")){
                return (T) Generador.generarPaisAleatorio();
            }  else if (methodName.contains("localidad") || methodName.contains("loc") || methodName.contains("local")){
                return (T) Generador.generarLocalidadAleatorio();
            }  else if (methodName.contains("titulo") || methodName.contains("tit") || methodName.contains("materia") || methodName.contains("mat")){
                return (T) Generador.generarPalabraConArticuloAleatoria();
            }
            return (T) Generador.generarPalabraSinArticuloAleatoria();
        } else if (type.isAssignableFrom(Date.class)) {
            int year = Generador.generarEnteroAleatorio(1900, 2015);
            int month = Generador.generarEnteroAleatorio(1, 12);
            int day = Generador.generarEnteroAleatorio(1, 31);
            Date d;
            Calendar cal = GregorianCalendar.getInstance();
            cal.set( year, month, day);
            d = cal.getTime();
            return (T) d;
        } else if (type.isAssignableFrom(Fecha.class)) {
            int year = Generador.generarEnteroAleatorio(1900, 2015);
            int month = Generador.generarEnteroAleatorio(1, 12);
            int day = Generador.generarEnteroAleatorio(1, 31);
            Date d;
            Calendar cal = GregorianCalendar.getInstance();
            cal.set( year, month, day);
            d = cal.getTime();
            SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
            return (T) new Fecha(sm.format(d));
        } else if (type.isAssignableFrom(double.class) || (type.isAssignableFrom(Double.class))) {
            return (T) Generador.generarDecimalAleatorio(0,500);
        } else if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class)) {
            return (T) new Float(Generador.generarEnteroAleatorio(0, 500));
        } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            //takeout all spaces
            Integer integer = Generador.generarEnteroAleatorio(0, 500);
            if (methodName.contains("dni")){
                integer = Generador.generarDNIAleatorio();
            } else if (methodName.contains("legajo") || methodName.contains("leg")){
                integer = Generador.generarLegajoAleatorio();
            }
            return (T) integer;
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public static <T> T[] copyArray(T[] vector){
        T[] another = (T[]) Array.newInstance(vector.getClass().getComponentType(), vector.length);
        System.arraycopy(vector, 0, another, 0, vector.length);
        return another;
    }

    public static String getSetMethod(String fieldName) {
        // TODO Auto-generated method stub
        String firstWithCapitalLetter = fieldName.toUpperCase().substring(0, 1);
        String restOfMethodName = fieldName.substring(1, fieldName.length());
        return Constants.SET + firstWithCapitalLetter + restOfMethodName;
    }
    
    public static String getGetMethod(String fieldName) {
        // TODO Auto-generated method stub
        String firstWithCapitalLetter = fieldName.toUpperCase().substring(0, 1);
        String restOfMethodName = fieldName.substring(1, fieldName.length());
        String methodName = Constants.GET + firstWithCapitalLetter + restOfMethodName;
        return methodName;
    }

    public static void handleException(Exception ex) {
        System.out.println(Constants.EXCEPCION_OCURRIDA_ + ex.getClass().getName()+" "+ex.getMessage());
    }
    
    public static IBinaryTree buildTree(Class theClass, Object[] inorder, Object[] postorder) {
        try {
            if (inorder.length == 0)
                return null;
            if (inorder.length == 1){
                IBinaryTree tree = ((IBinaryTree) theClass.newInstance());
                tree.setValue(inorder[0]);
                return tree;
            }
            // the last item in postorder is root
            IBinaryTree root = ((IBinaryTree) theClass.newInstance());
            root.setValue(postorder[postorder.length - 1]);

            int i = inorder.length - 1;
            for (; !inorder[i].equals(root.getValue()); i--)
                ;

            // inorder.length == postorder.length
            if (i < inorder.length - 1) {
                root.setRighSon(buildTree(theClass,
                        Arrays.copyOfRange(inorder, i + 1, inorder.length),
                        Arrays.copyOfRange(postorder, i, postorder.length - 1)));            
            }
            if (i > 0) {
                root.setLeftSon(buildTree(theClass, 
                        Arrays.copyOfRange(inorder, 0, i),
                        Arrays.copyOfRange(postorder, 0, i)));
            }

            return root;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
}

    public static boolean esMenor(String someString, String provincia1) {
        return someString.compareToIgnoreCase(provincia1) < 0;
    }

    public static boolean esMayor(String someString, String provincia1) {
        return someString.compareToIgnoreCase(provincia1) > 0;
    }

    public static boolean esIgual(String someString, String provincia1) {
        return someString.compareToIgnoreCase(provincia1) == 0;
    }
}
