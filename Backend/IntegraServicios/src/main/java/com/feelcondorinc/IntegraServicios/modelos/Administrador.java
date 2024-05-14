package com.feelcondorinc.IntegraServicios.modelos;
import java.util.Date;
import java.util.List;
import com.feelcondorinc.IntegraServicios.interfaces.AccionarAdministrador;


public class Administrador extends Usuario implements AccionarAdministrador {
    private Unidad unidad;
    private HorarioDisponibilidad horarioLaboral;

    public Administrador(int idUsuario, String contrasenia, RolUsuario rolUsuario, Unidad unidad, HorarioDisponibilidad horarioLaboral) {
        super(idUsuario, contrasenia, rolUsuario);
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

    public void asignarRecursoAUnidad(Unidad unidad, int intervaloMinimo, Date dia, int inicioRangoHorario, int finRangoHorario) {
        // Lógica para asignar un recurso a la unidad aquí
    }

    // Implementación de los métodos de la interfaz AccionarAdministrador

    public void crearEmpleado() {
        // Lógica para crear un nuevo empleado
    }


    public void crearAfiliado() {
        // Lógica para crear un nuevo afiliado
    }
}
