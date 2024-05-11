package com.feelcondorinc.IntegraServicios.modelos;
import java.util.Date;

class Reserva {
    private Usuario afiliado;
    private Recurso recurso;
    private Date diaReserva;
    private int inicioHoraReserva;
    private int finHoraReserva;
    private Empleado empleadoResponsable;
    private Date horaPrestamo;
    private Date horaDevolucion;

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
}


public class Recurso {
    private HorarioDisponibilidad horarioDisponible;
    private Unidad unidadAsociada;
    private int vecesPrestado;

    public Recurso(HorarioDisponibilidad horarioDisponible, Unidad unidadAsociada, int vecesPrestado) {
        this.horarioDisponible = horarioDisponible;
        this.unidadAsociada = unidadAsociada;
        this.vecesPrestado = vecesPrestado;
    }

    public HorarioDisponibilidad getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(HorarioDisponibilidad horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }

    public Unidad getUnidadAsociada() {
        return unidadAsociada;
    }

    public void setUnidadAsociada(Unidad unidadAsociada) {
        this.unidadAsociada = unidadAsociada;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }

    public Reserva reservarRecurso(Usuario afiliado, Date diaReserva, int inicioHoraReserva, int finHoraReserva) {
        // Verificar si el recurso está disponible en el horario especificado
        if (horarioDisponible.estaDisponible(diaReserva, inicioHoraReserva, 0)) {
            // Crear una nueva reserva y devolverla
            Reserva nuevaReserva = new Reserva(afiliado, this, diaReserva, inicioHoraReserva, finHoraReserva);
            // Actualizar el estado del recurso a en reserva
            horarioDisponible.getEstado().setEstado(EstadoRecurso.ENRESERVA);
            return nuevaReserva;
        } else {
            // El recurso no está disponible en el horario especificado
            throw new IllegalArgumentException("Recurso no disponible en el horario especificado");
        }
    }

    public void prestarRecurso(Reserva reserva, Empleado empleado) {
        // Verificar si el recurso está en estado de reserva
        if (horarioDisponible.getEstado().getEstado() == EstadoRecurso.ENRESERVA) {
            // Actualizar estado del recurso a prestado
            horarioDisponible.getEstado().setEstado(EstadoRecurso.PRESTADO);
            // Registrar empleado como responsable del préstamo
            reserva.setEmpleadoResponsable(empleado);
            // Registrar fecha y hora del préstamo
            reserva.setHoraPrestamo(new Date());
        } else {
            // El recurso no está en estado de reserva, por lo tanto no puede ser prestado
            throw new IllegalStateException("El recurso no está disponible para ser prestado en este momento.");
        }
    }

    public void devolverRecurso(Reserva reserva, Empleado empleado) {
        // Verificar si el recurso está en estado de préstamo
        if (horarioDisponible.getEstado().getEstado() == EstadoRecurso.PRESTADO) {
            // Actualizar estado del recurso a disponible si corresponde
            // Si hay reservas activas para el recurso, se mantiene en estado de reserva
            if (!horarioDisponible.getReservasActivas().isEmpty()) {
                horarioDisponible.getEstado().setEstado(EstadoRecurso.ENRESERVA);
            } else {
                horarioDisponible.getEstado().setEstado(EstadoRecurso.DISPONIBLE);
            }
            // Registrar fecha y hora de la devolución
            reserva.setHoraDevolucion(new Date());
        } else {
            // El recurso no está en estado de préstamo, por lo tanto no puede ser devuelto
            throw new IllegalStateException("El recurso no está en estado de préstamo para ser devuelto.");
        }
    }
}

