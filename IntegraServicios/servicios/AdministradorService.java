package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.feelcondorinc.IntegraServicios.repositorios.AdministradorRepository;
import com.feelcondorinc.IntegraServicios.modelos.Administrador;
import com.feelcondorinc.IntegraServicios.dtos.AdministradorDTO;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public Administrador findById(Long id) {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Administrador no encontrado con el ID: " + id));
    }

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }
    
    public AdministradorDTO getAdministradorById(Long id) {
        Administrador administrador = findById(id);
        return convertToDTO(administrador);
    }

    public AdministradorDTO createAdministrador(AdministradorDTO administradorDTO) {
        Administrador administrador = convertToEntity(administradorDTO);
        Administrador savedAdministrador = save(administrador);
        return convertToDTO(savedAdministrador);
    }

    public AdministradorDTO updateAdministrador(Long id, AdministradorDTO administradorDTO) {
        Administrador existingAdministrador = findById(id);
        existingAdministrador.setNombre(administradorDTO.getNombre());
        existingAdministrador.setCorreoElectronico(administradorDTO.getCorreoElectronico());
        Administrador updatedAdministrador = save(existingAdministrador);
        return convertToDTO(updatedAdministrador);
    }

    public void deleteAdministrador(Long id) {
        deleteById(id);
    }
    
    private AdministradorDTO convertToDTO(Administrador administrador) {
        return new AdministradorDTO(administrador.getId(), administrador.getNombre(), administrador.getCorreoElectronico());
    }

    private Administrador convertToEntity(AdministradorDTO administradorDTO) {
        Administrador administrador = new Administrador();
        administrador.setNombre(administradorDTO.getNombre());
        administrador.setCorreoElectronico(administradorDTO.getCorreoElectronico());
        // Puedes agregar más atributos aquí si es necesario
        return administrador;
    }
}