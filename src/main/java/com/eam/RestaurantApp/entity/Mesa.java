package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name="mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMesa;
    private int numeroMesa;
    private boolean estadoMesa;

    public Mesa(){ }

    public Mesa(int idMenu, boolean estadoMesa) {
        this.idMesa = idMenu;
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMenu(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
}
