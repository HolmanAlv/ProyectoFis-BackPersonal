package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.HorarioDisponibilidad;

public interface HorarioDisponibilidadRepository extends JpaRepository<HorarioDisponibilidad, Long> {
    List<HorarioDisponibilidad> findByFechaInicioBetweenAndFechaFinBetween(Date fechaInicio, Date fechaFin);
}

