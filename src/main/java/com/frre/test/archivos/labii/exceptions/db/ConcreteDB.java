package com.frre.test.archivos.labii.exceptions.db;

import com.frre.programacion.Generador;
import com.frre.test.archivos.labii.exceptions.exceptions.ZeroComprasException;
import com.frre.test.archivos.labii.exceptions.model.Compra;
import com.frre.test.archivos.labii.exceptions.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvargas on 10/2/15.
 */
public class ConcreteDB extends Database {

    private ArrayList<Compra> compras;

    @Override
    public void open() {
        fillData();
    }

    private void fillData() {

        ArrayList<Customer> customers = new ArrayList<Customer>();

        compras = new ArrayList<Compra>();

        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setIdUsuario(i);
            customer.setNombre(Generador.generarNombreAleatorio() + "," + Generador.generarApellidoAleatorio());
            customers.add(customer);
        }

        for (int i = 0; i < 1000; i++) {
            Compra compra = new Compra();
            compra.setIdProducto(Generador.generarEnteroAleatorio(1, 3456));
            compra.setCant(Generador.generarEnteroAleatorio(0, 5));
            compra.setPrecioUnitario(Generador.generarDecimalAleatorio(2, 45));

            int usuario = Generador.generarEnteroAleatorio(0,99);
            compra.setUsuario(customers.get(usuario));
            compra.setPrecioTotal(compra.getCant() * compra.getPrecioUnitario());

            compras.add(compra);
        }
    }

    @Override
    public void close() {
        this.compras.clear();
    }

    @Override
    public List<Compra> getRecordsForUser(int user) throws ZeroComprasException{

        ArrayList<Compra> comprasDelUser = new ArrayList<Compra>();

        for (int i = 0; i < compras.size(); i++) {
            Compra compra = compras.get(i);
            Customer customer = compra.getUsuario();
            if (customer.getIdUsuario() == user){
                if (compra.getCant() == 0){
                    throw new ZeroComprasException(compra);
                }
                comprasDelUser.add(compras.get(i));
            }
        }
        return comprasDelUser;
    }

    @Override
    public double getAveragePerUser(int user){

        ArrayList<Compra> comprasDelUser = new ArrayList<Compra>();

        int cantCompras = 0;
        int cantProductos = 0;

        for (int i = 0; i < compras.size(); i++) {
            Compra compra = compras.get(i);
            Customer customer = compra.getUsuario();
            if (customer.getIdUsuario() == user){
                int cant = compra.getCant();
                cantCompras++;
                cantProductos += cant;
            }
        }

        return cantProductos/cantCompras;
    }
}
