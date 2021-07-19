package com.eam.RestaurantApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
    private double totalPagar;
    private String descripcionFactura;

    private boolean estadoFactura;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date facturaFecha;

    @Column(name = "PEDIDOS_idPedidos")
    @NotNull
    private int idPedido;

    public Factura(){}

    public Factura(int idFactura, double totalPagar, String descripcionFactura,
                   boolean estadoFactura, Date facturaFecha, @NotNull int idPedido) {
        this.idFactura = idFactura;
        this.totalPagar = totalPagar;
        this.descripcionFactura = descripcionFactura;
        this.estadoFactura = estadoFactura;
        this.facturaFecha = facturaFecha;
        this.idPedido = idPedido;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getDescripcionFactura() {
        return descripcionFactura;
    }

    public void setDescripcionFactura(String descripcionFactura) {
        this.descripcionFactura = descripcionFactura;
    }

    public boolean isEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Date getFacturaFecha() {
        return facturaFecha;
    }

    public void setFacturaFecha(Date facturaFecha) {
        this.facturaFecha = facturaFecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
