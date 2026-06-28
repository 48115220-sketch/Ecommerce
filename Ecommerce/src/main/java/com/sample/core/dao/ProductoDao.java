package com.sample.core.dao;

import java.util.Date;
import java.util.List;

import com.sample.core.domain.Producto;

public interface ProductoDao {

    public List<Producto> obtenerTodos() throws Exception;

    public List<Producto> buscar(String criterio) throws Exception;

    public List<Producto> filtrarPrecio(double min, double max) throws Exception;

    public List<Producto> filtrarFecha(Date desde, Date hasta) throws Exception;

    public Producto obtenerPorId(int idProducto) throws Exception;

    public void insertar(Producto producto) throws Exception;

    public void actualizar(Producto producto) throws Exception;

    public void eliminar(int idProducto) throws Exception;

    public void actualizarStock(int idProducto, int nuevaCantidad) throws Exception;

}