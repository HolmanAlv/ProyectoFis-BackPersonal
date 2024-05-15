package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.EstadoRecursoDTO;
import com.feelcondorinc.IntegraServicios.servicios.EstadoRecursoService;
import com.feelcondorinc.IntegraServicios.modelos.EstadoRecurso;  


@RestController
@RequestMapping("/estados-recursos")
public class EstadoRecursoController {

    @Autowired
    private EstadoRecursoService estadoRecursoService;

    @GetMapping("/{id}")
    public EstadoRecursoDTO getEstadoRecurso(@PathVariable Long id) {
        EstadoRecurso estadoRecurso = estadoRecursoService.findById(id);
        return new EstadoRecursoDTO(estadoRecurso.getEstado().ordinal(), estadoRecurso.getDiaSemana());
    }

    @PostMapping("/")
    public EstadoRecursoDTO createEstadoRecurso(@RequestBody EstadoRecursoDTO estadoRecursoDTO) {
        EstadoRecurso estadoRecurso = new EstadoRecurso(
                EstadoRecurso.Estado.values()[estadoRecursoDTO.getId()],
                estadoRecursoDTO.getDiaSemana()
        );
        estadoRecurso = estadoRecursoService.save(estadoRecurso);
        return new EstadoRecursoDTO(estadoRecurso.getEstado().ordinal(), estadoRecurso.getDiaSemana());
    }

    @PutMapping("/{id}")
    public EstadoRecursoDTO updateEstadoRecurso(@PathVariable Long id, @RequestBody EstadoRecursoDTO estadoRecursoDTO) {
        EstadoRecurso estadoRecurso = new EstadoRecurso(
                EstadoRecurso.Estado.values()[estadoRecursoDTO.getId()],
                estadoRecursoDTO.getDiaSemana()
        );
        estadoRecurso = estadoRecursoService.save(estadoRecurso);
        return new EstadoRecursoDTO(estadoRecurso.getEstado().ordinal(), estadoRecurso.getDiaSemana());
    }

    @DeleteMapping("/{id}")
    public void deleteEstadoRecurso(@PathVariable Long id) {
        estadoRecursoService.deleteById(id);
    }
}
