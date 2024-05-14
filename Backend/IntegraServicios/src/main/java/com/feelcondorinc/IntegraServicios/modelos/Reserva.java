package com.feelcondorinc.IntegraServicios.modelos;


import java.util.Date;

public class Reserva {
    private Usuario afiliado;
    private Recurso recurso;
    private Date diaReserva;
    private int inicioHoraReserva;
    private int finHoraReserva;
    private Empleado empleadoResponsable;
    private Date horaPrestamo;
    private Date horaDevolucion;
    private EstadoReserva estadoReserva;

    public Reserva(Usuario afiliado, Recurso recurso, Date diaReserva, int inicioHoraReserva, int finHoraReserva) {
        this.afiliado = afiliado;
        this.recurso = recurso;
        this.diaReserva = diaReserva;
        this.inicioHoraReserva = inicioHoraReserva;
        this.finHoraReserva = finHoraReserva;
    }

    public Usuario getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Usuario afiliado) {
        this.afiliado = afiliado;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Date getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(Date diaReserva) {
        this.diaReserva = diaReserva;
    }

    public int getInicioHoraReserva() {
        return inicioHoraReserva;
    }

    public void setInicioHoraReserva(int inicioHoraReserva) {
        this.inicioHoraReserva = inicioHoraReserva;
    }

    public int getFinHoraReserva() {
        return finHoraReserva;
    }

    public void setFinHoraReserva(int finHoraReserva) {
        this.finHoraReserva = finHoraReserva;
    }

    public Empleado getEmpleadoResponsable() {
        return empleadoResponsable;
    }

    public void setEmpleadoResponsable(Empleado empleadoResponsable) {
        this.empleadoResponsable = empleadoResponsable;
    }

    public Date getHoraPrestamo() {
        return horaPrestamo;
    }

    public void setHoraPrestamo(Date horaPrestamo) {
        this.horaPrestamo = horaPrestamo;
    }

    public Date getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Date horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }


    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
