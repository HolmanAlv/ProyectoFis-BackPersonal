package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.HorarioDisponibilidadDTO;
import com.feelcondorinc.IntegraServicios.servicios.HorarioDisponibilidadService;

@RestController
@RequestMapping("/horarios-disponibilidad")
public class HorarioDisponibilidadController {

    @Autowired
    private HorarioDisponibilidadService horarioDisponibilidadService;

    @GetMapping("/{id}")
    public HorarioDisponibilidadDTO getHorarioDisponibilidad(@PathVariable Long id) {
        return horarioDisponibilidadService.getHorarioDisponibilidadById(id);
    }

    @PostMapping("/")
    public HorarioDisponibilidadDTO createHorarioDisponibilidad(@RequestBody HorarioDisponibilidadDTO horarioDisponibilidadDTO) {
        return horarioDisponibilidadService.createHorarioDisponibilidad(horarioDisponibilidadDTO);
    }

    @PutMapping("/{id}")
    public HorarioDisponibilidadDTO updateHorarioDisponibilidad(@PathVariable Long id, @RequestBody HorarioDisponibilidadDTO horarioDisponibilidadDTO) {
        return horarioDisponibilidadService.updateHorarioDisponibilidad(id, horarioDisponibilidadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHorarioDisponibilidad(@PathVariable Long id) {
        horarioDisponibilidadService.deleteHorarioDisponibilidad(id);
    }
}

