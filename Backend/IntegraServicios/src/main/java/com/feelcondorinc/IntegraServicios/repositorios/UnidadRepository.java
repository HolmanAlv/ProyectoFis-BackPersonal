package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {
    List<Unidad> findByIntervaloMinimoPrestamo(int intervaloMinimoPrestamo);
}

