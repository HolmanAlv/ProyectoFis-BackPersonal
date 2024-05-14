package com.feelcondorinc.IntegraServicios.modelos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Afiliado extends Usuario implements AccionarAfiliado {
    private String nombreAfiliado;
    private String numeroIdentificacion;
    private String correo;
    private String numeroContacto;

    public Afiliado(int idUsuario, String contrasenia, RolUsuario rolUsuario, String nombreAfiliado, String numeroIdentificacion, String correo, String numeroContacto) {
        super(idUsuario, contrasenia, rolUsuario);
        this.nombreAfiliado = nombreAfiliado;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.numeroContacto = numeroContacto;
    }

    public String getNombreAfiliado() {
        return nombreAfiliado;
    }

    public void setNombreAfiliado(String nombreAfiliado) {
        this.nombreAfiliado = nombreAfiliado;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    @Override
    public Reserva reservarRecurso(Recurso recurso, Date diaReserva, int inicioHoraReserva, int finHoraReserva) {
        return recurso.reservarRecurso(this, diaReserva, inicioHoraReserva, finHoraReserva);
    }

    @Override
    public List<Reserva> consultarReservasActivas() {
        List<Reserva> reservasActivas = new ArrayList<>();
    
        // Obtener todas las reservas del afiliado
        List<Reserva> todasLasReservas = RepositorioReservas.obtenerReservasPorAfiliado(this);
    
        // Filtrar las reservas activas
        for (Reserva reserva : todasLasReservas) {
            if (reserva.getEstadoReserva() == EstadoReserva.PENDIENTE || reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
            reservasActivas.add(reserva);
            }
        }
    
        return reservasActivas;
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        // Lógica para cancelar una reserva
        // Verificar si la reserva está en estado pendiente o confirmada
        if (reserva.getEstadoReserva() == EstadoReserva.PENDIENTE || reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
            // Cambiar el estado de la reserva a cancelada
            reserva.setEstadoReserva(EstadoReserva.CANCELADA);
        } else {
            // La reserva no puede ser cancelada en su estado actual
            throw new IllegalStateException("La reserva no puede ser cancelada en su estado actual.");
        }
    }
}

