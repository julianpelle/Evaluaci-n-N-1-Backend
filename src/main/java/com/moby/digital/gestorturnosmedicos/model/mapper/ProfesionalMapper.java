package com.moby.digital.gestorturnosmedicos.model.mapper;

import com.moby.digital.gestorturnosmedicos.dto.ProfesionalDTO;
import com.moby.digital.gestorturnosmedicos.entity.ProfesionalEntity;
import com.moby.digital.gestorturnosmedicos.model.Profesional;

import java.util.List;

public class ProfesionalMapper {
    public Profesional toModel(ProfesionalEntity profesionalEntity) {
        return new Profesional().IdProfesional(profesionalEntity.getId())
                .NombreProfesional(profesionalEntity.getNombre())
                .ApellidoProfesional(profesionalEntity.getApellido())
                .EspecialidadProfesional(profesionalEntity.getEspecialidad());

    }

    public Profesional toModel(ProfesionalDTO profesionalDTO) {
        return new Profesional()
                .IdProfesional(profesionalDTO.getId())
                .NombreProfesional(profesionalDTO.getNombre())
                .ApellidoProfesional(profesionalDTO.getApellido())
                .EspecialidadProfesional(profesionalDTO.getEspecialidad());
    }

    public List<Profesional> toModelList(List<ProfesionalEntity> profesionalEntity) {
        return profesionalEntity.stream().map(this::toModel).toList();
    }
}
