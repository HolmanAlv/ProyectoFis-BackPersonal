package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.RecursoDTO;
import com.feelcondorinc.IntegraServicios.servicios.RecursoService;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping("/{id}")
    public RecursoDTO getRecurso(@PathVariable Long id) {
        return recursoService.getRecursoById(id);
    }

    @PostMapping("/")
    public RecursoDTO createRecurso(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.createRecurso(recursoDTO);
    }

    @PutMapping("/{id}")
    public RecursoDTO updateRecurso(@PathVariable Long id, @RequestBody RecursoDTO recursoDTO) {
        return recursoService.updateRecurso(id, recursoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRecurso(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
    }
}
