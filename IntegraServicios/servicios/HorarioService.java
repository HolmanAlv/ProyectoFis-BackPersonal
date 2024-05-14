package com.feelcondorinc.IntegraServicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.feelcondorinc.IntegraServicios.repositorios.HorarioRepository;
import com.feelcondorinc.IntegraServicios.modelos.Horario;
import com.feelcondorinc.IntegraServicios.dtos.HorarioDTO;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public HorarioDTO findById(Long id) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Horario no encontrado con el ID: " + id));
        return convertToDto(horario);
    }

    public List<HorarioDTO> findAll() {
        return horarioRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public HorarioDTO save(HorarioDTO horarioDTO) {
        Horario horario = convertToEntity(horarioDTO);
        Horario savedHorario = horarioRepository.save(horario);
        return convertToDto(savedHorario);
    }

    public HorarioDTO update(Long id, HorarioDTO horarioDTO) {
        Optional<Horario> optionalHorario = horarioRepository.findById(id);
        if (optionalHorario.isPresent()) {
            Horario horario = optionalHorario.get();
            horario.setHoraInicio(horarioDTO.getHoraInicio());
            horario.setHoraFin(horarioDTO.getHoraFin());
            horario.setMinutoInicio(horarioDTO.getMinutoInicio());
            horario.setMinutoFin(horarioDTO.getMinutoFin());
            Horario updatedHorario = horarioRepository.save(horario);
            return convertToDto(updatedHorario);
        } else {
            throw new IllegalArgumentException("Horario no encontrado con el ID: " + id);
        }
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }

    private HorarioDTO convertToDto(Horario horario) {
        return new HorarioDTO(horario.getHoraInicio(), horario.getHoraFin(), horario.getMinutoInicio(), horario.getMinutoFin());
    }

    private Horario convertToEntity(HorarioDTO horarioDTO) {
        return new Horario(horarioDTO.getHoraInicio(), horarioDTO.getHoraFin(), horarioDTO.getMinutoInicio(), horarioDTO.getMinutoFin());
    }
}

