package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.modelos.Afiliado;
import com.feelcondorinc.IntegraServicios.servicios.AfiliadoService;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping("/{id}")
    public Afiliado getAfiliado(@PathVariable Long id) {
        return afiliadoService.findById(id);
    }

    @PostMapping("/")
    public Afiliado createAfiliado(@RequestBody Afiliado afiliado) {
        return afiliadoService.save(afiliado);
    }

    @PutMapping("/{id}")
    public Afiliado updateAfiliado(@PathVariable Long id, @RequestBody Afiliado afiliadoActualizado) {
        Afiliado afiliado = afiliadoService.findById(id); // Busca el afiliado por su ID
    
        // Actualiza los atributos del afiliado con los nuevos valores proporcionados
        afiliado.setNombreAfiliado(afiliadoActualizado.getNombreAfiliado());
        afiliado.setCorreo(afiliadoActualizado.getCorreo());
        afiliado.setNumeroIdentificacion(afiliadoActualizado.getNumeroIdentificacion());
        afiliado.setNumeroContacto(afiliadoActualizado.getNumeroContacto());
    
        // Guarda y retorna el afiliado actualizado
        return afiliadoService.updateAfiliado(id, afiliado);
    }
    

    @DeleteMapping("/{id}")
    public void deleteAfiliado(@PathVariable Long id) {
        afiliadoService.deleteById(id);
    }
}

