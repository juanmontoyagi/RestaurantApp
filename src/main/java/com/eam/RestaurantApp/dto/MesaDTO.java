package com.eam.RestaurantApp.dto;

public class MesaDTO {

    private int numeroMesa;
    private boolean estadoMesa;

    public MesaDTO(){}

    public MesaDTO(int numeroMesa, boolean estadoMesa) {
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
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
