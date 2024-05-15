package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.HorarioDTO;
import com.feelcondorinc.IntegraServicios.servicios.HorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/{id}")
    public HorarioDTO getHorario(@PathVariable Long id) {
        return horarioService.findById(id);
    }

    @PostMapping("/")
    public HorarioDTO createHorario(@RequestBody HorarioDTO horarioDTO) {
        return horarioService.save(horarioDTO);
    }

    @PutMapping("/{id}")
    public HorarioDTO updateHorario(@PathVariable Long id, @RequestBody HorarioDTO horarioDTO) {
        return horarioService.update(id, horarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioService.deleteById(id);
    }
}
