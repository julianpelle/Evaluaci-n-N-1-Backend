package com.moby.digital.gestorturnosmedicos.model.mapper;

import com.moby.digital.gestorturnosmedicos.dto.PacienteDTO;
import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.model.Paciente;

public class PacienteMapper {
    public PacienteEntity dtoToEntity(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setId(pacienteDTO.getId());
        pacienteEntity.setNombre(pacienteDTO.getNombre());
        pacienteEntity.setApellido(pacienteDTO.getApellido());
        pacienteEntity.setEmail(pacienteDTO.getEmail());
        return pacienteEntity;
    }

    public Paciente EntityToPaciente(PacienteEntity pacienteEntity) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteEntity.getId());
        paciente.setNombre(pacienteEntity.getNombre());
        paciente.setApellido(pacienteEntity.getApellido());
        paciente.setEmail(pacienteEntity.getEmail());
        return paciente;
    }
}
