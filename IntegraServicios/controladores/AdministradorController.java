package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.AdministradorDTO;
import com.feelcondorinc.IntegraServicios.servicios.AdministradorService;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/{id}")
    public AdministradorDTO getAdministrador(@PathVariable Long id) {
        return administradorService.getAdministradorById(id);
    }

    @PostMapping("/")
    public AdministradorDTO createAdministrador(@RequestBody AdministradorDTO administradorDTO) {
        return administradorService.createAdministrador(administradorDTO);
    }

    @PutMapping("/{id}")
    public AdministradorDTO updateAdministrador(@PathVariable Long id, @RequestBody AdministradorDTO administradorDTO) {
        return administradorService.updateAdministrador(id, administradorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrador(@PathVariable Long id) {
        administradorService.deleteAdministrador(id);
    }
}

