package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.HorarioRepository;
import com.feelcondorinc.IntegraServicios.modelos.Horario;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario findById(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Horario no encontrado con el ID: " + id));
    }

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }
}
