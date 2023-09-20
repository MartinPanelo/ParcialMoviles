package com.martintecno.parcialmoviles;

import java.io.Serializable;
import java.util.Date;

public class NotaModelo implements Serializable {

    private String titulo;
    private String descripcion;

    private Date fechaDeCreacion;


    public NotaModelo(String titulo, String descripcion, Date fechaDeCreacion ) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
