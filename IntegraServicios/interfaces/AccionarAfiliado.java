package com.feelcondorinc.IntegraServicios.interfaces;

import com.feelcondorinc.IntegraServicios.modelos.EstadoReserva;
import com.feelcondorinc.IntegraServicios.modelos.Recurso;
import com.feelcondorinc.IntegraServicios.modelos.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface AccionarAfiliado {

    public Reserva reservarRecurso(Recurso recurso, Date diaReserva, int inicioHoraReserva, int finHoraReserva);

    public List<Reserva> consultarReservasActivas();

    public void cancelarReserva(Reserva reserva);

}
