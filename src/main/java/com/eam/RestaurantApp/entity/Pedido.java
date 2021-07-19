package com.eam.RestaurantApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedidos;
    private boolean estadoPedido;

    @Column(name = "MESAS_idMesa")
    private int idMesa;
    @Column(name = "MESAS_USUARIOS_idUsuario")
    private int idUsuario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaPedido;

    public Pedido() { }

    public Pedido(int idPedidos, boolean estadoPedido, int idMesa, int idUsuario, Date fechaPedido) {
        this.idPedidos = idPedidos;
        this.estadoPedido = estadoPedido;
        this.idMesa = idMesa;
        this.idUsuario = idUsuario;
        this.fechaPedido = fechaPedido;
    }

    public int getIdPedido() {
        return idPedidos;
    }

    public void setIdPedido(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public boolean isEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}
