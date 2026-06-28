package com.sample.core.service;

import java.util.Date;
import java.util.List;

import com.sample.core.domain.Producto;

public interface ProductoService {

    public List<Producto> obtenerProductos() throws Exception;

    public List<Producto> buscarProductos(String criterio) throws Exception;

    public List<Producto> filtrarPrecio(double min, double max) throws Exception;

    public List<Producto> filtrarFecha(Date desde, Date hasta) throws Exception;

    public Producto obtenerProducto(int idProducto) throws Exception;

    public void registrarProducto(Producto producto) throws Exception;

    public void modificarProducto(Producto producto) throws Exception;

    public void eliminarProducto(int idProducto) throws Exception;

    public void actualizarStock(int idProducto, int nuevaCantidad) throws Exception;

}