package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.feelcondorinc.IntegraServicios.dtos.UnidadDTO;
import com.feelcondorinc.IntegraServicios.servicios.UnidadService;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping("/{id}")
    public ResponseEntity<UnidadDTO> getUnidad(@PathVariable Long id) {
        UnidadDTO unidadDTO = unidadService.getUnidadById(id);
        if (unidadDTO != null) {
            return new ResponseEntity<>(unidadDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UnidadDTO> createUnidad(@RequestBody UnidadDTO unidadDTO) {
        UnidadDTO createdUnidad = unidadService.createUnidad(unidadDTO);
        return new ResponseEntity<>(createdUnidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadDTO> updateUnidad(@PathVariable Long id, @RequestBody UnidadDTO unidadDTO) {
        UnidadDTO updatedUnidad = unidadService.updateUnidad(id, unidadDTO);
        if (updatedUnidad != null) {
            return new ResponseEntity<>(updatedUnidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidad(@PathVariable Long id) {
        boolean deleted = unidadService.deleteUnidad(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}







