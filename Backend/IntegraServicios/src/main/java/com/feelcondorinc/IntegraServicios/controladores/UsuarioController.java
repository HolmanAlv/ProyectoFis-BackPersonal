// UsuarioController.java
package com.feelcondorinc.IntegraServicios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.feelcondorinc.IntegraServicios.dtos.UsuarioDTO;
import com.feelcondorinc.IntegraServicios.servicios.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        if (usuarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.findAll();
        return ResponseEntity.ok(usuariosDTO);
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO createdUsuarioDTO = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updatedUsuarioDTO = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(updatedUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

