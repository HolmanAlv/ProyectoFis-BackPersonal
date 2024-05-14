package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByHoraInicioAndHoraFin(int horaInicio, int horaFin);
}

