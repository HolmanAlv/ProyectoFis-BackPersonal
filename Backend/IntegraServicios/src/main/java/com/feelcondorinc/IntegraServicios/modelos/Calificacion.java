package com.feelcondorinc.IntegraServicios.modelos;
public class Calificacion {
    private int idCalificacion;
    private Usuario usuario;
    private Usuario empleadoACalificar;
    private int cumplimientoHorarios;
    private int calidadRecurso;
    private int tratoPersonal;
    private String observacion;

    public Calificacion(int idCalificacion, Usuario usuario, Usuario empleadoACalificar, int cumplimientoHorarios, int calidadRecurso, int tratoPersonal, String observacion) {
        this.idCalificacion = idCalificacion;
        this.usuario = usuario;
        this.empleadoACalificar = empleadoACalificar;
        this.cumplimientoHorarios = cumplimientoHorarios;
        this.calidadRecurso = calidadRecurso;
        this.tratoPersonal = tratoPersonal;
        this.observacion = observacion;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getEmpleadoACalificar() {
        return empleadoACalificar;
    }

    public void setEmpleadoACalificar(Usuario empleadoACalificar) {
        this.empleadoACalificar = empleadoACalificar;
    }

    public int getCumplimientoHorarios() {
        return cumplimientoHorarios;
    }

    public void setCumplimientoHorarios(int cumplimientoHorarios) {
        this.cumplimientoHorarios = cumplimientoHorarios;
    }

    public int getCalidadRecurso() {
        return calidadRecurso;
    }

    public void setCalidadRecurso(int calidadRecurso) {
        this.calidadRecurso = calidadRecurso;
    }

    public int getTratoPersonal() {
        return tratoPersonal;
    }

    public void setTratoPersonal(int tratoPersonal) {
        this.tratoPersonal = tratoPersonal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void calificarServicio(int cumplimientoHorarios, int calidadRecurso, int tratoPersonal, String observacion) {
        // Lógica para calificar el servicio recibido
        this.cumplimientoHorarios = cumplimientoHorarios;
        this.calidadRecurso = calidadRecurso;
        this.tratoPersonal = tratoPersonal;
        this.observacion = observacion;
        // Se puede agregar lógica para almacenar la calificación en una base de datos :)
    }
}
