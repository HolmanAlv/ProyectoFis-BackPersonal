package com.feelcondorinc.IntegraServicios.dtos;

public class HorarioDTO {
    private int horaInicio;
    private int horaFin;
    private int minutoInicio;
    private int minutoFin;

    public HorarioDTO() {}

    public HorarioDTO(int horaInicio, int horaFin, int minutoInicio, int minutoFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minutoInicio = minutoInicio;
        this.minutoFin = minutoFin;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public int getMinutoFin() {
        return minutoFin;
    }

    public void setMinutoFin(int minutoFin) {
        this.minutoFin = minutoFin;
    }
}
