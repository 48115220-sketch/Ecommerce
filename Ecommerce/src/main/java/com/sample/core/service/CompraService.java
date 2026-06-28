package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Carrito;
import com.sample.core.domain.Compra;

public interface CompraService {

    public Compra realizarCompra(Carrito carrito, int idUsuario) throws Exception;

    public List<Compra> obtenerMisCompras(int idUsuario) throws Exception;

    public List<Compra> obtenerCompras() throws Exception;

}