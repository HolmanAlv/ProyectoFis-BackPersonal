package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.CalificacionRepository;
import com.feelcondorinc.IntegraServicios.modelos.Calificacion;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion findById(Long id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Calificación no encontrada con el ID: " + id));
    }

    public List<Calificacion> findAll() {
        return calificacionRepository.findAll();
    }

    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public void deleteById(Long id) {
        calificacionRepository.deleteById(id);
    }
}

