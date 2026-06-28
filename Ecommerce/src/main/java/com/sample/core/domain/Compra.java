package com.sample.core.domain;

import java.util.Date;

import com.sample.core.enums.EstadoCompra;

public class Compra extends GenericEntity {

    private int idUsuario;
    private Date fechaCompra;
    private EstadoCompra estado;

    public Compra() {
        super();
    }

    public Compra(int idCompra, int idUsuario, Date fechaCompra, EstadoCompra estado) {
        setId(idCompra);
        this.idUsuario = idUsuario;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    public int getIdCompra() {
        return getId();
    }

    public void setIdCompra(int idCompra) {
        setId(idCompra);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

}