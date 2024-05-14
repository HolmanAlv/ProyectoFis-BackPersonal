package com.feelcondorinc.IntegraServicios.modelos;

public class RolUsuario {

    public enum Rol {
        ADMIN,
        EMPLEADO,
        AFILIADO
        }

    private Rol rol;

    public RolUsuario() {
    }

    public RolUsuario(Rol rol) {
        this.rol = rol;
    }

    public Rol getRolUsuario() {
        return rol;
    }

    public void setRolUsuario(Rol rol) {
        this.rol = rol;
    }
}
