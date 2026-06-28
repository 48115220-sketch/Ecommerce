package com.sample.core.service;

import java.util.Date;
import java.util.List;

import com.sample.core.dao.ProductoDao;
import com.sample.core.dao.ProductoDaoImp;
import com.sample.core.domain.Producto;

public class ProductoServiceImp implements ProductoService {

    private ProductoDao productoDao = new ProductoDaoImp();

    @Override
    public List<Producto> obtenerProductos() throws Exception {
        return productoDao.obtenerTodos();
    }

    @Override
    public List<Producto> buscarProductos(String criterio) throws Exception {
        return productoDao.buscar(criterio);
    }

    @Override
    public List<Producto> filtrarPrecio(double min, double max) throws Exception {
        return productoDao.filtrarPrecio(min, max);
    }

    @Override
    public List<Producto> filtrarFecha(Date desde, Date hasta) throws Exception {
        return productoDao.filtrarFecha(desde, hasta);
    }

    @Override
    public Producto obtenerProducto(int idProducto) throws Exception {
        return productoDao.obtenerPorId(idProducto);
    }

    @Override
    public void registrarProducto(Producto producto) throws Exception {
        productoDao.insertar(producto);
    }

    @Override
    public void modificarProducto(Producto producto) throws Exception {
        productoDao.actualizar(producto);
    }

    @Override
    public void eliminarProducto(int idProducto) throws Exception {
        productoDao.eliminar(idProducto);
    }

    @Override
    public void actualizarStock(int idProducto, int nuevaCantidad) throws Exception {
        productoDao.actualizarStock(idProducto, nuevaCantidad);
    }

}