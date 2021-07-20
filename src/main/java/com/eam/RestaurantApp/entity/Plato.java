package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlato;

    private String nombrePlato;
    private String descripcionPlato;
    private int cantidadPlato;
    private double precioPlato;
    private String imagenPlato;
    private String clasificacionPlatos;

    public Plato(){}

    public Plato(int idPlato, String nombrePlato, String descripcionPlato, int cantidadPlato,
                 double precioPlato, String imagenPlato, String clasificacionPlatos) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.descripcionPlato = descripcionPlato;
        this.cantidadPlato = cantidadPlato;
        this.precioPlato = precioPlato;
        this.imagenPlato = imagenPlato;
        this.clasificacionPlatos = clasificacionPlatos;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public int getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getImagenPlato() {
        return imagenPlato;
    }

    public void setImagenPlato(String imagenPlato) {
        this.imagenPlato = imagenPlato;
    }

    public String getClasificacionPlatos() {
        return clasificacionPlatos;
    }

    public void setClasificacionPlatos(String clasificacionPlatos) {
        this.clasificacionPlatos = clasificacionPlatos;
    }
}
