package com.sample.core.domain;

public class DetalleCompra extends GenericEntity {

    private Compra compra;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public DetalleCompra() {
        super();
        this.producto = new Producto();
    }

    public DetalleCompra(int idDetalle, Compra compra, Producto producto, int cantidad, double precioUnitario) {
        setId(idDetalle);
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetalle() {
        return getId();
    }

    public void setIdDetalle(int idDetalle) {
        setId(idDetalle);
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return cantidad * precioUnitario;
    }

}