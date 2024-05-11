package com.feelcondorinc.IntegraServicios.dtos;

public class AdministradorDTO extends UsuarioDTO {
    public AdministradorDTO() {
        super();
    }

    public AdministradorDTO(int id, String nombre, String correoElectronico) {
        super(id, nombre, correoElectronico);
    }
}
