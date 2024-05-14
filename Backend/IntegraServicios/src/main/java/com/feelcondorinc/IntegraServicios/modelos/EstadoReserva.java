package com.feelcondorinc.IntegraServicios.modelos;

public class EstadoReserva {

    public enum Estado {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA,
        FINALIZADACONCALIFICACION,
        FINALIZADASINCALIFICACION
    }

    private Estado estado;

    public EstadoReserva() {
    }

    public EstadoReserva(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstadoReserva() {
        return estado;
    }

    public void setEstadoReserva(Estado estado) {
        this.estado = estado;
    }
}
