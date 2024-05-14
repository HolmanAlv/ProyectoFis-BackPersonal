package com.feelcondorinc.IntegraServicios.dtos;

public class EstadoRecursoDTO {
    private int id;
    private String diaSemana;

    public EstadoRecursoDTO() {}

    public EstadoRecursoDTO(int id, String diaSemana) {
        this.id = id;
        this.diaSemana = diaSemana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}

