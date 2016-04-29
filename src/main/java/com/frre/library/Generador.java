/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.library;

import com.frre.library.data.DataSource;
import com.frre.library.data.Constants;

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
        return split[generarEnteroAleatorio(0, split.length - 1)].trim();
    }

    public static String generarStringAleatorio(){
        String appelidos = DataSource.nombres ;
        String[] split = appelidos.split(Constants.NEW_LINE);
        String retorno = split[generarEnteroAleatorio(0, split.length - 1)].trim();
        return retorno;
    }
    
     public static String generarNombreAleatorio(){
        String appelidos = DataSource.nombres;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarEnteroAleatorio(0, split.length - 1)].trim();
    }
     
    public static String generarPalabraConArticuloAleatoria(){
        String appelidos = DataSource.palabras;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarEnteroAleatorio(0, split.length - 1)].trim();
    }
    
    public static String generarPalabraSinArticuloAleatoria(){
        String appelidos = DataSource.palabras;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarEnteroAleatorio(0, split.length - 1)].substring(2).trim();
    }
    
    public static String generarPaisAleatorio(){
        String appelidos = DataSource.paises;
        String[] split = appelidos.split(Constants.NEW_LINE);
        String pais = split[generarEnteroAleatorio(0, split.length - 1)];
        int comma = pais.indexOf(",");
        return pais.substring(0, comma).trim();
    }
    
    public static String generarLocalidadAleatorio(){
        String appelidos = DataSource.localidades;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarEnteroAleatorio(0, split.length - 1)].trim();
    }

    public static String generarPatenteALeatoria(){
       StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII
            char letra = (char)resultado;
            builder.append(letra);
        }
        builder.append(Generador.generarEnteroAleatorio(100,999));
        return builder.toString();
    }

     public static String generarPciaAleatorio(){
        String appelidos = DataSource.pcias;
        String[] split = appelidos.split(Constants.NEW_LINE);
        return split[generarEnteroAleatorio(0, split.length - 1)].trim();
    }
    
    public static int generarEnteroAleatorio(int desde, int hasta){
        return rnd.nextInt(hasta-desde+1)+desde;
    }

    public static Double generarDecimalAleatorio(int desde, int hasta){
        String entera = String.valueOf(rnd.nextInt(hasta-desde+1)+desde);
        String decimal = String.valueOf(rnd.nextInt(99 - 0 + 1)+0);
        return new Double(entera+"."+decimal);
    }


    public static int generarLegajoAleatorio(){
        return generarEnteroAleatorio(16000, 25000);
    }

    public static int generarDNIAleatorio(){
        return generarEnteroAleatorio(30100500, 40200323);
    }
    
    public static Fecha generarFechaAleatorio(int desdeA, int hastaA){
        StringBuilder builder = new StringBuilder();
        builder.append(generarEnteroAleatorio(1, 28))
                .append(Constants.DATE_SEPARATOR)
                .append(generarEnteroAleatorio(1, 12))
                .append(Constants.DATE_SEPARATOR)
                .append(generarEnteroAleatorio(desdeA, hastaA));
        return new Fecha(builder.toString());
    }
    
}
