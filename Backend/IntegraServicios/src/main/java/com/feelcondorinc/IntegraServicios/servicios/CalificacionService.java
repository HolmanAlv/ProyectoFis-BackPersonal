package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.feelcondorinc.IntegraServicios.repositorios.CalificacionRepository;
import com.feelcondorinc.IntegraServicios.dtos.CalificacionDTO;
import com.feelcondorinc.IntegraServicios.modelos.Calificacion;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public CalificacionDTO getCalificacionById(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Calificación no encontrada con el ID: " + id));
        return convertToDto(calificacion);
    }

    public List<Calificacion> getAllCalificaciones() {
        return calificacionRepository.findAll();
    }

    public CalificacionDTO createCalificacion(CalificacionDTO calificacionDTO) {
        Calificacion calificacion = convertToEntity(calificacionDTO);
        Calificacion savedCalificacion = calificacionRepository.save(calificacion);
        return convertToDto(savedCalificacion);
    }

    public CalificacionDTO updateCalificacion(Long id, CalificacionDTO calificacionDTO) {
        Optional<Calificacion> optionalCalificacion = calificacionRepository.findById(id);
        if (optionalCalificacion.isPresent()) {
            Calificacion calificacion = optionalCalificacion.get();
            calificacion.setCumplimientoHorarios(calificacionDTO.getCumplimientoHorarios());
            calificacion.setCalidadRecurso(calificacionDTO.getCalidadRecurso());
            calificacion.setTratoPersonal(calificacionDTO.getTratoPersonal());
            calificacion.setObservacion(calificacionDTO.getObservacion());
            // Lógica adicional según sea necesario, como actualizar el usuario y el empleado a calificar
            return convertToDto(calificacionRepository.save(calificacion));
        } else {
            throw new IllegalArgumentException("Calificación no encontrada con el ID: " + id);
        }
    }

    public void deleteCalificacion(Long id) {
        calificacionRepository.deleteById(id);
    }

    private CalificacionDTO convertToDto(Calificacion calificacion) {
        CalificacionDTO dto = new CalificacionDTO();
        dto.setId(calificacion.getIdCalificacion());
        dto.setPuntuacion((calificacion.getCumplimientoHorarios() + calificacion.getCalidadRecurso() + calificacion.getTratoPersonal()) / 3);
        dto.setComentario(calificacion.getObservacion());
        return dto;
    }

    private Calificacion convertToEntity(CalificacionDTO calificacionDTO) {
        Calificacion calificacion = new Calificacion();
        // Aquí puedes setear los valores de la calificación según lo que tengas en el DTO
        calificacion.setCumplimientoHorarios(calificacionDTO.getCumplimientoHorarios());
        calificacion.setCalidadRecurso(calificacionDTO.getCalidadRecurso());
        calificacion.setTratoPersonal(calificacionDTO.getTratoPersonal());
        calificacion.setObservacion(calificacionDTO.getObservacion());
        return calificacion;
    }
}
