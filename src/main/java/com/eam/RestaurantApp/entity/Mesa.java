package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name="mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMesa;
    private int numeroMesa;
    private boolean estadoMesa;
    private String ocupacionMesa;


    public Mesa(){ }

    public Mesa(int idMesa, int numeroMesa, boolean estadoMesa, String ocupacionMesa) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
        this.ocupacionMesa = ocupacionMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
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

    public String getOcupacionMesa() {
        return ocupacionMesa;
    }

    public void setOcupacionMesa(String ocupacionMesa) {
        this.ocupacionMesa = ocupacionMesa;
    }
}
