package com.feelcondorinc.IntegraServicios.dtos;

public class CalificacionDTO {
    private int id;
    private int puntuacion;
    private String comentario;
    private int cumplimientoHorarios;
    private int calidadRecurso;
    private int tratoPersonal;
    private String observacion;

    public CalificacionDTO() {}

    public CalificacionDTO(int id, int puntuacion, String comentario) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
}
