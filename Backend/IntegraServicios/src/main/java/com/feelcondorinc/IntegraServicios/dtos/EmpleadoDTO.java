package com.feelcondorinc.IntegraServicios.dtos;

public class EmpleadoDTO extends UsuarioDTO {
    public EmpleadoDTO() {
        super();
    }

    public EmpleadoDTO(int id, String nombre, String correoElectronico) {
        super(id, nombre, correoElectronico);
    }
}