package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_platos")
public class PedidoPlato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedidos_platos")
    private int idPedidoPlato;

    @Column(name = "PLATOS_idPlato")
    private int idPlato;

    @Column(name = "PEDIDOS_idPedidos")
    private int idPedido;

    private int cantidadPedidoPlato;

    public PedidoPlato(){}

    public PedidoPlato(int idPedidoPlato, int idPlato, int idPedido, int cantidadPedidoPlato) {
        this.idPedidoPlato = idPedidoPlato;
        this.idPlato = idPlato;
        this.idPedido = idPedido;
        this.cantidadPedidoPlato = cantidadPedidoPlato;
    }

    public int getIdPedidoPlato() {
        return idPedidoPlato;
    }

    public void setIdPedidoPlato(int idPedidoPlato) {
        this.idPedidoPlato = idPedidoPlato;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidadPedidoPlato() {
        return cantidadPedidoPlato;
    }

    public void setCantidadPedidoPlato(int cantidadPedidoPlato) {
        this.cantidadPedidoPlato = cantidadPedidoPlato;
    }
}
