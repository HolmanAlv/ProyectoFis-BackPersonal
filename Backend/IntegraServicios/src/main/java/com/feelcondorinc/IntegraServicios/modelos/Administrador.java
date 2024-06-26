package com.feelcondorinc.IntegraServicios.modelos;
import java.util.Date;
import java.util.List;
import com.feelcondorinc.IntegraServicios.interfaces.AccionarAdministrador;

public class Administrador extends Usuario implements AccionarAdministrador {
    private Unidad unidad;
    private HorarioDisponibilidad horarioLaboral;

    public Administrador(int idUsuario, String contrasenia, String nombre, Unidad unidad, HorarioDisponibilidad horarioLaboral) {
        super(idUsuario, contrasenia, RolUsuario.ADMINISTRADOR);
        this.unidad = unidad;
        this.horarioLaboral = horarioLaboral;
    }
    
    // Constructor por defecto
    public Administrador() {
        super();
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
    
    // Métodos de la interfaz AccionarAdministrador
    @Override
    public void asignarRecursoAUnidad(Unidad unidad, int intervaloMinimo, Date dia, int inicioRangoHorario, int finRangoHorario) {
        // Implementación de asignarRecursoAUnidad
    }

    @Override
    public void crearEmpleado() {
        // Implementación de crearEmpleado
    }


    public void crearAfiliado() {
        // Implementación de crearAfiliado
    }
    
    // Métodos para establecer y obtener nombre, correo electrónico e ID
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getCorreoElectronico() {
        return super.getCorreoElectronico();
    }

    @Override
    public void setCorreoElectronico(String correoElectronico) {
        super.setCorreoElectronico(correoElectronico);
    }


    public int getId() {
        return super.getIdUsuario();
    }
}
