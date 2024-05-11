package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.RecursoRepository;
import com.feelcondorinc.IntegraServicios.modelos.Recurso;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    @Autowired
    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public Recurso findById(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recurso no encontrado con el ID: " + id));
    }

    public List<Recurso> findAll() {
        return recursoRepository.findAll();
    }

    public Recurso save(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public void deleteById(Long id) {
        recursoRepository.deleteById(id);
    }
}

