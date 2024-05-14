package com.feelcondorinc.IntegraServicios.modelos;

import java.util.Date;


public class Recurso {
    
    private String nombre;
    private String descripcion;
    private HorarioDisponibilidad horarioDisponible;
    private Unidad unidadAsociada;
<<<<<<< HEAD
    private int vecesPrestado;
    private long id;
=======
    private static int vecesPrestado;
    
>>>>>>> afd52bb3b97c9796f0b4c155cd06361bc66efba6

    public Recurso(String nombre, String descripcion, HorarioDisponibilidad horarioDisponible, Unidad unidadAsociada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarioDisponible = horarioDisponible;
        this.unidadAsociada = unidadAsociada;
        vecesPrestado = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

