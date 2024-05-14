package com.feelcondorinc.IntegraServicios.interfaces;

import com.feelcondorinc.IntegraServicios.modelos.Unidad;

import java.util.Date;

public interface AccionarAdministrador {

    public void asignarRecursoAUnidad(Unidad unidad, int intervaloMinimo, Date dia, int inicioRangoHorario, int finRangoHorario);
    public void crearEmpleado();
    public void crearAfiliado();
}
