package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.AfiliadoRepository;
import com.feelcondorinc.IntegraServicios.modelos.Afiliado;

@Service
public class AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;

    @Autowired
    public AfiliadoService(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    public Afiliado findById(Long id) {
        return afiliadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Afiliado no encontrado con el ID: " + id));
    }

    public List<Afiliado> findAll() {
        return afiliadoRepository.findAll();
    }

    public Afiliado save(Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }

    public void deleteById(Long id) {
        afiliadoRepository.deleteById(id);
    }
}
