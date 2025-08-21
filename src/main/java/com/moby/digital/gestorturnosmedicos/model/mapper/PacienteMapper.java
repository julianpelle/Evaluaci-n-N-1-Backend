package com.moby.digital.gestorturnosmedicos.model.mapper;

import com.moby.digital.gestorturnosmedicos.dto.PacienteDTO;
import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.model.Paciente;

import java.util.List;

public class PacienteMapper {

    public Paciente toModel(PacienteDTO dto) {
        Paciente p = new Paciente();
        p.setId(dto.getId());
        p.setNombre(dto.getNombre());
        p.setApellido(dto.getApellido());
        p.setEmail(dto.getEmail());
        p.setDni(dto.getDni());
        return p;
    }

    public Paciente toModel(PacienteEntity pacienteEntity) {
        Paciente p = new Paciente();
        p.setId(pacienteEntity.getId());
        p.setNombre(pacienteEntity.getNombre());
        p.setApellido(pacienteEntity.getApellido());
        p.setEmail(pacienteEntity.getEmail());
        p.setDni(pacienteEntity.getDni());
        return p;
    }

    public PacienteEntity toEntity(Paciente paciente) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setId(paciente.getId());
        pacienteEntity.setNombre(paciente.getNombre());
        pacienteEntity.setApellido(paciente.getApellido());
        pacienteEntity.setEmail(paciente.getEmail());
        pacienteEntity.setDni(paciente.getDni());
        return pacienteEntity;
    }

    public List<Paciente> toModelList(List<PacienteEntity> pacienteEntity) {
        return pacienteEntity.stream().map(this::toModel).toList();
    }

}
