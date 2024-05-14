package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByUnidadAsociadaId(int unidadId);
}

