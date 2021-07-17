package com.eam.RestaurantApp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
    private double precioFactura;
    private String descripcionFactura;

    @Column(name = "MESA_idMesa")
    @NotNull
    private int idMesa;

    @Column(name = "USUARIO_idUsuario")
    @NotNull
    private int idUsuario;

    public Factura(){}

    public Factura(int idFactura, double precioFactura, String descripcionFactura, @NotNull int idMesa, @NotNull int idUsuario) {
        this.idFactura = idFactura;
        this.precioFactura = precioFactura;
        this.descripcionFactura = descripcionFactura;
        this.idMesa = idMesa;
        this.idUsuario = idUsuario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getPrecioFactura() {
        return precioFactura;
    }

    public void setPrecioFactura(double precioFactura) {
        this.precioFactura = precioFactura;
    }

    public String getDescripcionFactura() {
        return descripcionFactura;
    }

    public void setDescripcionFactura(String descripcionFactura) {
        this.descripcionFactura = descripcionFactura;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
