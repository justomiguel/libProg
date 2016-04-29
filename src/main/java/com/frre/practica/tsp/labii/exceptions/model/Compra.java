package com.frre.practica.tsp.labii.exceptions.model;

/**
 * Created by jvargas on 10/2/15.
 */
public class Compra {

    private Customer usuario;
    private int idProducto;
    private int cant;
    private double precioUnitario;
    private double precioTotal;

    @Override
    public String toString() {
        return "Compra{" +
                "usuario=" + usuario +
                ", idProducto=" + idProducto +
                ", cant=" + cant +
                ", precioUnitario=" + precioUnitario +
                ", precioTotal=" + precioTotal +
                '}';
    }

    public Customer getUsuario() {
        return usuario;
    }

    public void setUsuario(Customer usuario) {
        this.usuario = usuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
