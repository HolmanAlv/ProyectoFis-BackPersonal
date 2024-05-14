package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.RecursoDTO;
import com.feelcondorinc.IntegraServicios.servicios.RecursoService;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    @Autowired
    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> getRecurso(@PathVariable Long id) {
        RecursoDTO recursoDTO = recursoService.getRecursoById(id);
        return ResponseEntity.ok(recursoDTO);
    }

    @PostMapping("/")
    public ResponseEntity<RecursoDTO> createRecurso(@RequestBody RecursoDTO recursoDTO) {
        RecursoDTO createdRecursoDTO = recursoService.createRecurso(recursoDTO);
        return new ResponseEntity<>(createdRecursoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDTO> updateRecurso(@PathVariable Long id, @RequestBody RecursoDTO recursoDTO) {
        RecursoDTO updatedRecursoDTO = recursoService.updateRecurso(id, recursoDTO);
        return ResponseEntity.ok(updatedRecursoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
        return ResponseEntity.noContent().build();
    }
}

