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
    private int ocupacionMesa;

    @Column(name = "USUARIOS_idUsuario")
    private int idUsuario;

    public Mesa(){ }

    public Mesa(int idMesa, int numeroMesa, boolean estadoMesa, int ocupacionMesa, int idUsuario) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
        this.ocupacionMesa = ocupacionMesa;
        this.idUsuario = idUsuario;
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

    public int getOcupacionMesa() {
        return ocupacionMesa;
    }

    public void setOcupacionMesa(int ocupacionMesa) {
        this.ocupacionMesa = ocupacionMesa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
