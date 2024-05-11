package com.feelcondorinc.IntegraServicios.modelos;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class HorarioDisponibilidad {
    private List<Reserva> reservasActivas;

    public HorarioDisponibilidad() {
        this.reservasActivas = new ArrayList<>();
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }
    private int idElemento;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Horario> horarioDiario;
    private EstadoRecurso estado;

    public HorarioDisponibilidad(int idElemento, Date fechaInicio, Date fechaFin, List<Horario> horarioDiario, EstadoRecurso estado) {
        this.idElemento = idElemento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horarioDiario = horarioDiario;
        this.estado = estado;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
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

    public List<Horario> getHorarioDiario() {
        return horarioDiario;
    }

    public void setHorarioDiario(List<Horario> horarioDiario) {
        this.horarioDiario = horarioDiario;
    }

    public EstadoRecurso getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecurso estado) {
        this.estado = estado;
    }

    public boolean estaDisponible(Date fecha, int hora, int minuto) {
        // Verificar si la fecha está dentro del rango de disponibilidad
        if (fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0) {
            // Iterar sobre todos los horarios y verificar si alguno coincide con el momento dado
            for (Horario horario : horarioDiario) {
                // Verificar si el horario actual está dentro del horario de disponibilidad
                if (hora > horario.getHoraInicio() || (hora == horario.getHoraInicio() && minuto >= horario.getMinutoInicio())) {
                    if (hora < horario.getHoraFin() || (hora == horario.getHoraFin() && minuto < horario.getMinutoFin())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int obtenerDiaSemana(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        // Obtener el día de la semana, donde Domingo es 1, Lunes es 2, ..., Sábado es 7
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        // Convertir al formato esperado por el sistema, donde Domingo es 0, Lunes es 1, ..., Sábado es 6
        return (diaSemana + 5) % 7;
    }

    private String obtenerNombreDiaSemana(int diaSemana) {
        switch (diaSemana) {
            case Calendar.MONDAY:
                return "Lunes";
            case Calendar.TUESDAY:
                return "Martes";
            case Calendar.WEDNESDAY:
                return "Miércoles";
            case Calendar.THURSDAY:
                return "Jueves";
            case Calendar.FRIDAY:
                return "Viernes";
            case Calendar.SATURDAY:
                return "Sábado";
            case Calendar.SUNDAY:
                return "Domingo";
            default:
                return "";
        }
    }
}

    