package com.feelcondorinc.IntegraServicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feelcondorinc.IntegraServicios.modelos.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    List<Administrador> findByUnidadAsociadaId(int unidadId);
}
