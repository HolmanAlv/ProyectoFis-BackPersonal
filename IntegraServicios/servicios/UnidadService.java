package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.feelcondorinc.IntegraServicios.dtos.UnidadDTO;
import com.feelcondorinc.IntegraServicios.dtos.HorarioDisponibilidadDTO;
import com.feelcondorinc.IntegraServicios.dtos.EstadoRecursoDTO;
import com.feelcondorinc.IntegraServicios.modelos.Unidad;
import com.feelcondorinc.IntegraServicios.modelos.HorarioDisponibilidad;
import com.feelcondorinc.IntegraServicios.modelos.EstadoRecurso;
import com.feelcondorinc.IntegraServicios.repositorios.UnidadRepository;
import com.feelcondorinc.IntegraServicios.dtos.HorarioDTO;
import com.feelcondorinc.IntegraServicios.modelos.Horario;

@Service
public class UnidadService {

    private final UnidadRepository unidadRepository;

    @Autowired
    public UnidadService(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    public UnidadDTO getUnidadById(Long id) {
        Optional<Unidad> unidad = unidadRepository.findById(id);
        return unidad.map(this::toDTO).orElse(null);
    }

    public List<UnidadDTO> getAllUnidades() {
        List<Unidad> unidades = unidadRepository.findAll();
        return unidades.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UnidadDTO createUnidad(UnidadDTO unidadDTO) {
        Unidad unidad = toEntity(unidadDTO);
        Unidad savedUnidad = unidadRepository.save(unidad);
        return toDTO(savedUnidad);
    }

    public UnidadDTO updateUnidad(Long id, UnidadDTO unidadDTO) {
        Optional<Unidad> unidadOptional = unidadRepository.findById(id);
        if (unidadOptional.isPresent()) {
            Unidad unidad = unidadOptional.get();
            updateEntityFromDTO(unidadDTO, unidad);
            Unidad updatedUnidad = unidadRepository.save(unidad);
            return toDTO(updatedUnidad);
        } else {
            return null;
        }
    }

    public boolean deleteUnidad(Long id) {
        if (unidadRepository.existsById(id)) {
            unidadRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private UnidadDTO toDTO(Unidad unidad) {
        if (unidad == null) {
            return null;
        }
        HorarioDisponibilidad horarioDisponibilidad = unidad.getHorarioDisponible();
        HorarioDisponibilidadDTO horarioDisponibilidadDTO = new HorarioDisponibilidadDTO(
                horarioDisponibilidad.getIdElemento(),
                horarioDisponibilidad.getFechaInicio(),
                horarioDisponibilidad.getFechaFin(),
                horarioDisponibilidad.getHorarioDiario().stream()
                        .map(horario -> new HorarioDTO(horario.getHoraInicio(), horario.getMinutoInicio(), horario.getHoraFin(), horario.getMinutoFin()))
                        .collect(Collectors.toList()),
                new EstadoRecursoDTO(horarioDisponibilidad.getEstado().getId(), horarioDisponibilidad.getEstado().getDiaSemana())
        );
        return new UnidadDTO(
                unidad.getId(),
                unidad.getNombre(),
                unidad.getIntervaloMinimoPrestamo(),
                horarioDisponibilidadDTO
        );
    }

    private Unidad toEntity(UnidadDTO unidadDTO) {
        if (unidadDTO == null) {
            return null;
        }
        HorarioDisponibilidadDTO horarioDisponibilidadDTO = unidadDTO.getHorarioDisponible();
        EstadoRecurso estadoRecurso = new EstadoRecurso(horarioDisponibilidadDTO.getEstado().getId(), horarioDisponibilidadDTO.getEstado().getDiaSemana());
        HorarioDisponibilidad horarioDisponibilidad = new HorarioDisponibilidad(
                horarioDisponibilidadDTO.getIdRecurso(),
                horarioDisponibilidadDTO.getFechaInicio(),
                horarioDisponibilidadDTO.getFechaFin(),
                horarioDisponibilidadDTO.getHorarioDiario().stream()
                        .map(horarioDTO -> new Horario(horarioDTO.getHoraInicio(), horarioDTO.getMinutoInicio(), horarioDTO.getHoraFin(), horarioDTO.getMinutoFin()))
                        .collect(Collectors.toList()),
                estadoRecurso
        );
        return new Unidad(
                unidadDTO.getId(),
                unidadDTO.getNombre(),
                unidadDTO.getIntervaloMinimoPrestamo(),
                horarioDisponibilidad,
                new ArrayList<>(), // Inicializa con listas vacías o ajusta según tu lógica de negocio
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    private void updateEntityFromDTO(UnidadDTO unidadDTO, Unidad unidad) {
        if (unidadDTO == null || unidad == null) {
            return;
        }
        unidad.setNombre(unidadDTO.getNombre()); // Actualiza el nombre según el DTO
        unidad.setIntervaloMinimoPrestamo(unidadDTO.getIntervaloMinimoPrestamo());
        HorarioDisponibilidadDTO horarioDisponibilidadDTO = unidadDTO.getHorarioDisponible();
        HorarioDisponibilidad horarioDisponibilidad = unidad.getHorarioDisponible();
        horarioDisponibilidad.setIdElemento(horarioDisponibilidadDTO.getIdRecurso());
        horarioDisponibilidad.setFechaInicio(horarioDisponibilidadDTO.getFechaInicio());
        horarioDisponibilidad.setFechaFin(horarioDisponibilidadDTO.getFechaFin());
        horarioDisponibilidad.setHorarioDiario(horarioDisponibilidadDTO.getHorarioDiario().stream()
                .map(horarioDTO -> new Horario(horarioDTO.getHoraInicio(), horarioDTO.getMinutoInicio(), horarioDTO.getHoraFin(), horarioDTO.getMinutoFin()))
                .collect(Collectors.toList()));
        EstadoRecursoDTO estadoRecursoDTO = horarioDisponibilidadDTO.getEstado();
        EstadoRecurso estadoRecurso = new EstadoRecurso(estadoRecursoDTO.getId(), estadoRecursoDTO.getDiaSemana());
        horarioDisponibilidad.setEstado(estadoRecurso);
    }
}

