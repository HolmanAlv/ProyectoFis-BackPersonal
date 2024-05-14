package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Afiliado;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
    List<Afiliado> findByNumeroldentificacion(String numeroIdentificacion);
}

