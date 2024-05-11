package com.feelcondorinc.IntegraServicios.modelos;
import java.util.List;

public class Empleado extends Usuario implements AccionarEmpleado {
    private Unidad unidad;
    private HorarioDisponibilidad horarioLaboral;

    public Empleado(int idUsuario, String contrasenia, String nombre, Unidad unidad, HorarioDisponibilidad horarioLaboral) {
        super(idUsuario, contrasenia, nombre);
        this.unidad = unidad;
        this.horarioLaboral = horarioLaboral;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public HorarioDisponibilidad getHorarioLaboral() {
        return horarioLaboral;
    }

    public void setHorarioLaboral(HorarioDisponibilidad horarioLaboral) {
        this.horarioLaboral = horarioLaboral;
    }

    @Override
    public List<Reserva> consultarReservasEnUnidad() {
        return unidad.consultarReservasEnUnidad();
    }
}

