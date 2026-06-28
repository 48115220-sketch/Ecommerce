package com.sample.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<DetalleCompra> detalles;

    public Carrito() {
        detalles = new ArrayList<>();
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public void agregarProducto(DetalleCompra detalle) {
        detalles.add(detalle);
    }

    public void eliminarProducto(int indice) {

        if (indice >= 0 && indice < detalles.size()) {
            detalles.remove(indice);
        }

    }

    public void vaciar() {
        detalles.clear();
    }

    public double getTotal() {

        double total = 0;

        for (DetalleCompra detalle : detalles) {
            total += detalle.getSubTotal();
        }

        return total;
    }

    public boolean estaVacio() {
        return detalles.isEmpty();
    }

}