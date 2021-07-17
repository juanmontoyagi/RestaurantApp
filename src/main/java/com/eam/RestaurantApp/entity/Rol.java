package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    private String nombreRol;
    private boolean estadoRol;

    public Rol() { }

    public Rol(int idRol, String nombreRol, boolean estadoRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(boolean estadoRol) {
        this.estadoRol = estadoRol;
    }
}
