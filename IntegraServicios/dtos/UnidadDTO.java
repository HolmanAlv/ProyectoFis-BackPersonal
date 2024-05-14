package com.feelcondorinc.IntegraServicios.dtos;

public class UnidadDTO {
    private int id;
    private String nombre;
    private int intervaloMinimoPrestamo;
    private HorarioDisponibilidadDTO horarioDisponible;

    public UnidadDTO() {}

    public UnidadDTO(int id, String nombre, int intervaloMinimoPrestamo, HorarioDisponibilidadDTO horarioDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.intervaloMinimoPrestamo = intervaloMinimoPrestamo;
        this.horarioDisponible = horarioDisponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntervaloMinimoPrestamo() {
        return intervaloMinimoPrestamo;
    }

    public void setIntervaloMinimoPrestamo(int intervaloMinimoPrestamo) {
        this.intervaloMinimoPrestamo = intervaloMinimoPrestamo;
    }

    public HorarioDisponibilidadDTO getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(HorarioDisponibilidadDTO horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
}
