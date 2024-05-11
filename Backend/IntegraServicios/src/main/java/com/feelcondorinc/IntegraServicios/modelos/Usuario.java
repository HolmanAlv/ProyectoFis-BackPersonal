package com.feelcondorinc.IntegraServicios.modelos;
public class Usuario {
    private int idUsuario;
    private String contrasenia;
    private RolUsuario rolUsuario;

    public Usuario(int idUsuario, String contrasenia, RolUsuario rolUsuario) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
        this.rolUsuario = rolUsuario;
    }

   
    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    
    public void IngresarAlSistema() {
        // Lógica para el ingreso al sistema aquí
    }

    public void RealizarAccionEspecifica() {
        // Lógica para realizar acciones específicas aquí
    }
}
