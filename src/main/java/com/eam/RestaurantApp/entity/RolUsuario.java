package com.eam.RestaurantApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles_usuarios")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario_Rol")
    private int idUsuario_rol;

    @Column(name = "USUARIO_idUsuario")
    private int idUsuario;

    @Column(name = "ROL_idRol")
    private int idRol;

    public RolUsuario(){}

    public RolUsuario(int idUsuario_rol, int idUsuario, int idRol) {
        this.idUsuario_rol = idUsuario_rol;
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    public int getIdUsuario_rol() {
        return idUsuario_rol;
    }

    public void setIdUsuario_rol(int idUsuario_rol) {
        this.idUsuario_rol = idUsuario_rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
