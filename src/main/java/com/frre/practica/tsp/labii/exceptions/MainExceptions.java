package com.frre.practica.tsp.labii.exceptions;

import com.frre.practica.tsp.labii.exceptions.exceptions.NoCustomerOrShopsException;
import com.frre.test.archivos.labii.exceptions.db.DBHelper;

/**
 * Created by jvargas on 10/2/15.
 */
public class MainExceptions {

    public static void main(String[] args){
        DBHelper.openDB();

        try {
            System.out.println(DBHelper.getAveragePerUser(90));
        } catch (NoCustomerOrShopsException e) {
            e.printStackTrace();
        }
            DBHelper.closeDB();


        // try {
            //List<Compra> compras = DBHelper.getRecordsForUser(35);
            //for(Compra compra : compras){
              //  System.out.println(compra);
            //}
       // } catch (ZeroComprasException e){
          //  System.out.println(e.getMessage()+" por culpa de "+e.getCompra());
       // }
    }
}
