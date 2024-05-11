package com.feelcondorinc.IntegraServicios.dtos;

public class CalificacionDTO {
    private int id;
    private int puntuacion;
    private String comentario;

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
}
