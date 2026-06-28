package com.sample.core.domain;

import java.util.Date;

public class Producto extends GenericEntity {

    private String urlImagen;
    private String titulo;
    private Date fechaPublic;
    private int stock;
    private String descripcion;
    private String caracteristicas;
    private double precio;

    public Producto() {
        super();
    }

    public Producto(int idProducto, String urlImagen, String titulo, Date fechaPublic, int stock, String descripcion,
            String caracteristicas, double precio) {
        setId(idProducto);
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.fechaPublic = fechaPublic;
        this.stock = stock;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
    }

    public int getIdProducto() {
        return getId();
    }

    public void setIdProducto(int idProducto) {
        setId(idProducto);
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublic() {
        return fechaPublic;
    }

    public void setFechaPublic(Date fechaPublic) {
        this.fechaPublic = fechaPublic;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
