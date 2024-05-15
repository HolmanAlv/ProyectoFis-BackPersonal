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
    private int id;

    public EstadoRecurso(Estado estado, String diaSemana) {
        this.estado = estado;
        this.diaSemana = diaSemana;
    }

    public EstadoRecurso(int estadoId, String diaSemana) {
        this.estado = Estado.values()[estadoId];
        this.diaSemana = diaSemana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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