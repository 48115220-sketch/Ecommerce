package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.DetalleCompra;
import com.sample.core.exceptions.ErrorException;

public interface DetalleCompraDao {

    void insertar(DetalleCompra detalle) throws Exception;

    List<DetalleCompra> obtenerPorCompra(int idCompra) throws ErrorException;

    void eliminarPorDetalle(int idDetalle) throws Exception;

}