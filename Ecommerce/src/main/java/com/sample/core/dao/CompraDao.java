package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Compra;
import com.sample.core.enums.EstadoCompra;

public interface CompraDao {

    public int insertarCompra(Compra compra) throws Exception;

    public Compra obtenerPorId(int idCompra) throws Exception;

    public List<Compra> obtenerPorUsuario(int idUsuario) throws Exception;

    public List<Compra> listarCompras() throws Exception;

    public void actualizarEstado(int idCompra, EstadoCompra estado) throws Exception;

}