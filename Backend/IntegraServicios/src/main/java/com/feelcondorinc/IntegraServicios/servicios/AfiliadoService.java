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

    public Afiliado updateAfiliado(Long id, Afiliado afiliadoActualizado) {
        Afiliado afiliado = findById(id); // Busca el afiliado por su ID
    
        // Actualiza los atributos del afiliado con los nuevos valores proporcionados
        afiliado.setNombreAfiliado(afiliadoActualizado.getNombreAfiliado());
        afiliado.setCorreo(afiliadoActualizado.getCorreo());
        afiliado.setNumeroIdentificacion(afiliadoActualizado.getNumeroIdentificacion());
        afiliado.setNumeroContacto(afiliadoActualizado.getNumeroContacto());
    
        // Guarda y retorna el afiliado actualizado
        return afiliadoRepository.save(afiliado);
    }
    

    public void deleteById(Long id) {
        afiliadoRepository.deleteById(id);
    }
}
