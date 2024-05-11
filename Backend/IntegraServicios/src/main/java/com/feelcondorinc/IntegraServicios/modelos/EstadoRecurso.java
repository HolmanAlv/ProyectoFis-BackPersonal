package com.feelcondorinc.IntegraServicios.modelos;
public class EstadoRecurso {
    public enum Estado {
        NODISPONIBLE,
        DISPONIBLE,
        ENRESERVA,
        PRESTADO
    }

    public static final EstadoRecurso.Estado PRESTADO = null;

    public static final EstadoRecurso.Estado ENRESERVA = null;

    public static final EstadoRecurso.Estado DISPONIBLE = null;

    private Estado estado;
    private String diaSemana;

    public EstadoRecurso() {
    }

    public EstadoRecurso(Estado estado, String diaSemana) {
        this.estado = estado;
        this.diaSemana = diaSemana;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}

