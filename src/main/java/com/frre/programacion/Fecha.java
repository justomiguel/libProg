/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 * @author Cleo
 */
public final class Fecha {

    private DateTime myDate;

    public Fecha() {
        this.myDate = new DateTime();
    }

    public Fecha(String fecha) {
        myDate = new DateTime();
        setFecha(fecha);
    }

    public String getFecha() {
        StringBuilder builder = new StringBuilder();
        builder.append(myDate.getDayOfMonth())
                .append("/")
                .append(myDate.getMonthOfYear())
                .append("/")
                .append(myDate.getYear());
        return builder.toString();
    }

    public final void setFecha(String fecha) {
        String[] date = fecha.trim().split("/");
        int year = Integer.parseInt(date[2].trim());
        int month = Integer.parseInt(date[1].trim());
        int day = Integer.parseInt(date[0].trim());
        myDate = new DateTime(year, month, day, 0, 0, DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT-3")));
    }

    public void menosDias(int days) {
        this.myDate = myDate.minusDays(days);
    }
    
    public void menosAnios(int years) {
        this.myDate = myDate.minusYears(years);
    }
    
    public void menosMeses(int month) {
        this.myDate = myDate.minusMonths(month);
    }
    
    public void masDias(int days) {
        this.myDate = myDate.plusDays(days);
    }
    
    public void masAnios(int years) {
        this.myDate = myDate.plusYears(years);
    }
    
    public void masMeses(int month) {
        this.myDate = myDate.plusMonths(month);
    }

    public int getMes() {
        return myDate.getMonthOfYear();
    }

    public int getAnio() {
        return myDate.getYear();
    }

    public int getDia() {
        return myDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return this.getFecha(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
