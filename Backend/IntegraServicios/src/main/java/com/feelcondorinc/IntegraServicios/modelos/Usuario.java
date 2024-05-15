package com.feelcondorinc.IntegraServicios.modelos;
public class Usuario {
    private int idUsuario;
    private String contrasenia;
    private String nombre;
    private String correoElectronico;
    private String rolUsuario;

    public Usuario(int idUsuario, String contrasenia, String nombre) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    public Usuario() {
        // Constructor sin argumentos
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void IngresarAlSistema() {
        // Lógica para el ingreso al sistema aquí
    }

    public void RealizarAccionEspecifica() {
        // Lógica para realizar acciones específicas aquí
    }
    public static class RolUsuario {
        public static final String ADMINISTRADOR = "Administrador";
        public static final String EMPLEADO = "Empleado";
        public static final String AFILIADO = "Afiliado";
    }

}

