package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.CalificacionDTO;
import com.feelcondorinc.IntegraServicios.servicios.CalificacionService;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/{id}")
    public CalificacionDTO getCalificacion(@PathVariable Long id) {
        return calificacionService.getCalificacionById(id);
    }

    @PostMapping("/")
    public CalificacionDTO createCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.createCalificacion(calificacionDTO);
    }

    @PutMapping("/{id}")
    public CalificacionDTO updateCalificacion(@PathVariable Long id, @RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.updateCalificacion(id, calificacionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCalificacion(@PathVariable Long id) {
        calificacionService.deleteCalificacion(id);
    }
}

