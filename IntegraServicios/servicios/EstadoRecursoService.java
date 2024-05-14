package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.EstadoRecursoRepository;
import com.feelcondorinc.IntegraServicios.modelos.EstadoRecurso;

@Service
public class EstadoRecursoService {

    private final EstadoRecursoRepository estadoRecursoRepository;

    @Autowired
    public EstadoRecursoService(EstadoRecursoRepository estadoRecursoRepository) {
        this.estadoRecursoRepository = estadoRecursoRepository;
    }

    public EstadoRecurso findById(Long id) {
        return estadoRecursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estado de recurso no encontrado con el ID: " + id));
    }

    public List<EstadoRecurso> findAll() {
        return estadoRecursoRepository.findAll();
    }

    public EstadoRecurso save(EstadoRecurso estadoRecurso) {
        return estadoRecursoRepository.save(estadoRecurso);
    }

    public void deleteById(Long id) {
        estadoRecursoRepository.deleteById(id);
    }

    public EstadoRecurso findByDiaSemana(String diaSemana) {
        return estadoRecursoRepository.findByDiaSemana(diaSemana);
    }
}

