package com.feelcondorinc.IntegraServicios.dtos;

import java.util.List;
import java.util.Date;

public class HorarioDisponibilidadDTO {
    private int idRecurso;
    private Date fechaInicio;
    private Date fechaFin;
    private List<HorarioDTO> horarioDiario;
    private EstadoRecursoDTO estado;

    public HorarioDisponibilidadDTO() {}

    public HorarioDisponibilidadDTO(int idRecurso, Date fechaInicio, Date fechaFin, List<HorarioDTO> horarioDiario, EstadoRecursoDTO estado) {
        this.idRecurso = idRecurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horarioDiario = horarioDiario;
        this.estado = estado;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<HorarioDTO> getHorarioDiario() {
        return horarioDiario;
    }

    public void setHorarioDiario(List<HorarioDTO> horarioDiario) {
        this.horarioDiario = horarioDiario;
    }

    public EstadoRecursoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecursoDTO estado) {
        this.estado = estado;
    }
}
