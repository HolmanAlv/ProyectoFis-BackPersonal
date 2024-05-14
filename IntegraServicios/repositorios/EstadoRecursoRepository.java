package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.feelcondorinc.IntegraServicios.modelos.EstadoRecurso;

public interface EstadoRecursoRepository extends JpaRepository<EstadoRecurso, Long> {
    EstadoRecurso findByDiaSemana(String diaSemana);
}

