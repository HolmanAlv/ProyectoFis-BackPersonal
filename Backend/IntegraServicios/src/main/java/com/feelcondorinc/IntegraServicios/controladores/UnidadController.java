package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.UnidadDTO;
import com.feelcondorinc.IntegraServicios.servicios.UnidadService;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping("/{id}")
    public UnidadDTO getUnidad(@PathVariable Long id) {
        return unidadService.getUnidadById(id);
    }

    @PostMapping("/")
    public UnidadDTO createUnidad(@RequestBody UnidadDTO unidadDTO) {
        return unidadService.createUnidad(unidadDTO);
    }

    @PutMapping("/{id}")
    public UnidadDTO updateUnidad(@PathVariable Long id, @RequestBody UnidadDTO unidadDTO) {
        return unidadService.updateUnidad(id, unidadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUnidad(@PathVariable Long id) {
        unidadService.deleteUnidad(id);
    }
}

