package com.frre.test.archivos.labii.files;

import com.frre.programacion.Generador;

import java.util.*;
import java.io.*;
import java.util.Set;

/**
 * Created by jvargas on 9/12/15.
 */
public class Main {

    public static void main(String[] args){
        File dir = new File("./fotos");

        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles()) {
                    System.out.println(f.getName());
                    String fileName = f.getName().substring(4,12);
                    String year = fileName.substring(0, 4);
                    String month = fileName.substring(4,6);
                    String day = fileName.substring(6,8);
                    String seconds = f.getName().substring(15, 19);
                    System.out.println(year+"-"+month+"-"+day+" 16.46."+seconds);
                    File newfile = new File(year+"-"+month+"-"+day+" 16.46."+seconds+".jpg");
                    if (f.renameTo(newfile)) {
                        System.out.println("Rename succesful");
                    } else {
                        System.out.println("Rename failed");
                    }
                    // TODO: handle exception

            }
        }
    }
}
