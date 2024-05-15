package com.feelcondorinc.IntegraServicios.modelos;

import java.util.List;
import com.feelcondorinc.IntegraServicios.interfaces.AccionarEmpleado;


public class Empleado extends Usuario implements AccionarEmpleado {
    private Unidad unidad;
    private HorarioDisponibilidad horarioLaboral;
    private int id;
    private String nombre;
    private String correoElectronico;

    public Empleado(int idUsuario, String contrasenia, String rolUsuario, Unidad unidad, HorarioDisponibilidad horarioLaboral) {
        super(idUsuario, contrasenia, RolUsuario.EMPLEADO);
        this.unidad = unidad;
        this.horarioLaboral = horarioLaboral;
        
    }

    public Empleado() {
    }

    public Empleado(int id, String nombre, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public List<Reserva> consultarReservasEnUnidad() {
        return unidad.consultarReservasEnUnidad();
    }


}

