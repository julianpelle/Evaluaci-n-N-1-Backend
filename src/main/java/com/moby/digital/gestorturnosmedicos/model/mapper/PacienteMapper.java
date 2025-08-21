package com.moby.digital.gestorturnosmedicos.model.mapper;

import com.moby.digital.gestorturnosmedicos.dto.PacienteDTO;
import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.model.Paciente;

public class PacienteMapper {
    public Paciente toModel(PacienteDTO pacienteDTO) {
        return new Paciente()
             .dni(pacienteDTO.getDni())
             .nombre(pacienteDTO.getNombre())
             .apellido(pacienteDTO.getApellido())
             .email(pacienteDTO.getEmail())
             .id(pacienteDTO.getId());
    }

    public Paciente toModel(PacienteEntity pacienteEntity) {
        return new Paciente()
        .id(pacienteEntity.getId())
        .nombre(pacienteEntity.getNombre())
        .apellido(pacienteEntity.getApellido())
        .email(pacienteEntity.getEmail())
        .id(pacienteEntity.getId());

    }
}
