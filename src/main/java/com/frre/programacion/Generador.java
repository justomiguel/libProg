/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.util.Random;

/**
 *
 * @author justomiguel
 */
public class Generador {
    
    static Random rnd = new Random();
    
    public static String generarApellidoAleatorio(){
        String appelidos = DataSource.apellidos;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].trim();
    }
    
     public static String generarNombreAleatorio(){
        String appelidos = DataSource.nombres;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].trim();
    }
     
    public static String generarPalabraConArticuloAleatoria(){
        String appelidos = DataSource.palabras;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].trim();
    }
    
    public static String generarPalabraSinArticuloAleatoria(){
        String appelidos = DataSource.palabras;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].substring(2).trim();
    }
    
    public static String generarPaisAleatorio(){
        String appelidos = DataSource.paises;
        String[] split = appelidos.split(Constants.NEW_LINE);
        String pais = split[generarNumeroAleatorio(0, split.length)];
        int comma = pais.indexOf(",");
        return pais.substring(0, comma).trim();
    }
    
    public static String generarLocalidadAleatorio(){
        String appelidos = DataSource.localidades;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].trim();
    }
    
     public static String generarPciaAleatorio(){
        String appelidos = DataSource.pcias;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarNumeroAleatorio(0, split.length)].trim();
    }
    
    public static int generarNumeroAleatorio(int desde, int hasta){
        return rnd.nextInt(hasta-desde+1)+desde;
    }
    
    public static int generarDNIAleatorio(){
        return generarNumeroAleatorio(30100500, 40200323);
    }
    
    public static Fecha generarFechaAleatorio(int desdeA, int hastaA){
        StringBuilder builder = new StringBuilder();
        builder.append(generarNumeroAleatorio(1, 28))
                .append(Constants.DATE_SEPARATOR)
                .append(generarNumeroAleatorio(1, 12))
                .append(Constants.DATE_SEPARATOR)
                .append(generarNumeroAleatorio(desdeA, hastaA));
        return new Fecha(builder.toString());
    }
    
}
