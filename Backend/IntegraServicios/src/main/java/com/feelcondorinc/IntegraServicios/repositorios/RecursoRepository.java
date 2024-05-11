package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    List<Recurso> findByUnidadAsociadaId(int unidadId);
}
