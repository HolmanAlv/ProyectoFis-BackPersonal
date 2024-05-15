package com.feelcondorinc.IntegraServicios.dtos;

public class RecursoDTO {
    private HorarioDisponibilidadDTO horarioDisponible;
    private UnidadDTO unidadAsociada;
    private int vecesPrestado;
    private long id;

    public RecursoDTO() {}

    public RecursoDTO(HorarioDisponibilidadDTO horarioDisponible, UnidadDTO unidadAsociada, int vecesPrestado) {
        this.horarioDisponible = horarioDisponible;
        this.unidadAsociada = unidadAsociada;
        this.vecesPrestado = vecesPrestado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HorarioDisponibilidadDTO getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(HorarioDisponibilidadDTO horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }

    public UnidadDTO getUnidadAsociada() {
        return unidadAsociada;
    }

    public void setUnidadAsociada(UnidadDTO unidadAsociada) {
        this.unidadAsociada = unidadAsociada;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }
}
