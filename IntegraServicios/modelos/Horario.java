package com.feelcondorinc.IntegraServicios.modelos;
public class Horario {
    private int horaInicio;
    private int horaFin;
    private int minutoInicio;
    private int minutoFin;

    public Horario(int horaInicio, int horaFin, int minutoInicio, int minutoFin) {
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

    public boolean estaEnHorario(int hora, int minuto) {
        if (hora > horaInicio && hora < horaFin) {
            return true;
        } else if (hora == horaInicio && minuto >= minutoInicio) {
            return true;
        } else return hora == horaFin && minuto <= minutoFin;
    }
}
