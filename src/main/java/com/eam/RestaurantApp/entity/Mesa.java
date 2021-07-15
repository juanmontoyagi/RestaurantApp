package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name="mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMesa;
    private String descripcionMesa;
    private boolean estadoMesa;

    public Mesa(){ }

    public Mesa(int idMesa, boolean estadoMesa) {
        this.idMesa = idMesa;
        this.descripcionMesa = descripcionMesa;
        this.estadoMesa = estadoMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getDescripcionMesa() {
        return descripcionMesa;
    }

    public void setDescripcionMesa(String descripcionMesa) {
        this.descripcionMesa = descripcionMesa;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
}
