package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.EmpleadoDTO;
import com.feelcondorinc.IntegraServicios.servicios.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/{id}")
    public EmpleadoDTO getEmpleado(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping("/")
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.createEmpleado(empleadoDTO);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.updateEmpleado(id, empleadoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }
}
