package com.feelcondorinc.IntegraServicios.modelos;
import java.util.Date;
import java.util.List;


public class Administrador extends Usuario implements AccionarAdministrador {
    private Unidad unidad;
    private HorarioDisponibilidad horarioLaboral;

    public Administrador(int idUsuario, String contrasenia, String nombre, Unidad unidad, HorarioDisponibilidad horarioLaboral) {
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
    // Lógica para asignar un recurso a la unidad
    @Override
    public void asignarRecursoAUnidad(Unidad unidad, int intervaloMinimo, Date dia, int inicioRangoHorario, int finRangoHorario) {
        // Lógica para asignar un recurso a la unidad aquí
    }

    // Implementación de los métodos de la interfaz AccionarAdministrador
    @Override
    public void crearEmpleado() {
        // Lógica para crear un nuevo empleado
    }

    @Override
    public void crearAfiliado() {
        // Lógica para crear un nuevo afiliado
    }
}
